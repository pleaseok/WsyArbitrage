# REST API
https://api.huobi.pro

# Websocket Feed（行情）
wss://api.huobi.pro/ws

# Websocket Feed（资产和订单）
wss://api.huobi.pro/ws/v1

## 签名认证
**除公共接口(基础信息，行情数据)外的私有接口均必须使用API Key做签名认证，以校验参数或参数值再传输途中是否发生更改**
- 方法请求地址:api.huobi.pro
- API访问秘钥:API Key中的Access Key
- 签名方法:用户计算签名的基于哈希的协议 HmacSHA256
- 签名版本:签名协议的版本
- 时间戳
- 必选和可选参数
- 签名:签名计算得出的值，用于确保签名有效和未被篡改

## 基础信息
* 获取所有交易对
```
    GET "https://api.huobi.pro/v1/common/symbols"
    "data": [
        {
            "base-currency": "btc",  // 交易对中的基础货币
            "quote-currency": "usdt", // 交易对中的报价货币
            "price-precision": 2,  // 交易对报价的精度(小数点后位数) - integer
            "amount-precision": 4,  // 交易对基础币种计数精度(小数点后位数) - integer
            "symbol-partition": "main", // 交易区，可能值[main,innovation,bifurcation]
            "symbol": "btcusdt"
        }
        {
            "base-currency": "eth",
            "quote-currency": "usdt",
            "price-precision": 2,
            "amount-precision": 4,
            "symbol-partition": "main",
            "symbol": "ethusdt"
        }
      ]
```
* 获取所有币种
```
    GET "https://api.huobi.pro/v1/common/currencys"
    "data": [
        "usdt",
        "eth",
        "etc"
      ]
```
* 获取当前系统时间
```
    GET "https://api.huobi.pro/v1/common/timestamp"
    "data": 1494900087029
```

## 行情数据
* K线数据(蜡烛图) - 此接口返回历史K线数据
```
    GET "https://api.huobi.pro/market/history/kline?period=1day&size=200&symbol=btcusdt"
    [
      {
        "id": 1499184000,   // integer,时间戳，秒
        "amount": 37593.0266,   // float,以基础币种计量的交易对
        "count": 0,    // integer,交易次数
        "open": 1935.2000,  // float,本阶段开盘价
        "close": 1879.0000, // float,本阶段收盘价
        "low": 1856.0000,   // float,本阶段最低价
        "high": 1940.0000,  // float,本阶段最高价
        "vol": 71031537.97866500    // 以报价币种计量的交易对
      }
    ]
```
    
* 聚合行情 - 此接口获取ticker信息同时提供最少24小时的交易聚合信息
```
    GET "https://api.huobi.pro/market/detail/merged?symbol=ethusdt"
    {
      "id":1499225271,  // integer
      "ts":1499225271000, 
      "close":1885.0000,
      "open":1960.0000,
      "high":1985.0000,
      "low":1856.0000,
      "amount":81486.2926,
      "count":42122,
      "vol":157052744.85708200,
      "ask":[1885.0000,21.8804],
      "bid":[1884.0000,1.6702]
    }
```
    
* 所有交易对的最新 - 获得所有交易对的 tickers，数据取值时间区间为24小时滚动。
  **此接口返回所有交易对的 ticker，因此数据量较大。**
```
  GET "https://api.huobi.pro/market/tickers"
  [  
      {  
          "open":0.044297,      // 开盘价
          "close":0.042178,     // 收盘价
          "low":0.040110,       // 最高价
          "high":0.045255,      // 最低价
          "amount":12880.8510,  
          "count":12838,
          "vol":563.0388715740,
          "symbol":"ethbtc"
      },
      {  
          "open":0.008545,
          "close":0.008656,
          "low":0.008088,
          "high":0.009388,
          "amount":88056.1860,
          "count":16077,
          "vol":771.7975953754,
          "symbol":"ltcbtc"
      }
  ]
```

* 市场深度数据 - 此接口返回指定交易对的当前市场深度数据
```
    GET "https://api.huobi.pro/market/depth?symbol=btcusdt&type=step2"
    {
        "version": 31615842081,
        "ts": 1489464585407,
        "bids": [
          [7964, 0.0678], // [price, amount]
          [7963, 0.9162],
          [7961, 0.1],
          [7960, 12.8898],
          [7958, 1.2],
          ...
        ],
        "asks": [
          [7979, 0.0736],
          [7980, 1.0292],
          [7981, 5.5652],
          [7986, 0.2416],
          [7990, 1.9970],
          ...
        ]
      }
```
      
* 最近市场成交记录 - 此接口返回指定交易对最新的一个交易记录
```
    GET "https://api.huobi.pro/market/trade?symbol=ethusdt"
    {
        "id": 600848670,
        "ts": 1489464451000,
        "data": [
          {
            "id": 600848670,
            "price": 7962.62,
            "amount": 0.0122,
            "direction": "buy",
            "ts": 1489464451000
          }
        ]
    }
```
    
* 获得近期交易记录 - 此接口返回指定交易对近期的所有交易记录
```
    GET "https://api.huobi.pro/market/history/trade?symbol=ethusdt&size=2"
    [  
       {  
          "id":31618787514,
          "ts":1544390317905,
          "data":[  
             {  
                "amount":9.000000000000000000,
                "ts":1544390317905,
                "id":3161878751418918529341,
                "price":94.690000000000000000,
                "direction":"sell"
             },
             {  
                "amount":73.771000000000000000,
                "ts":1544390317905,
                "id":3161878751418918532514,
                "price":94.660000000000000000,
                "direction":"sell"
             }
          ]
       },
       {  
          "id":31618776989,
          "ts":1544390311353,
          "data":[  
             {  
                "amount":1.000000000000000000,
                "ts":1544390311353,
                "id":3161877698918918522622,
                "price":94.710000000000000000,
                "direction":"buy"
             }
          ]
       }
    ]
```
    
* 最近24小时行情数据 - 此接口返回最近24小时的行情数据汇总
```
    GET "https://api.huobi.pro/market/detail?symbol=ethusdt"
    {  
       "amount":613071.438479561,
       "open":86.21,
       "close":94.35,
       "high":98.7,
       "id":31619471534,
       "count":138909,
       "low":84.63,
       "version":31619471534,
       "vol":5.6617373443873316E7
    }
```
    
## 账户相关
**访问账户相关的接口需要进行签名认证**

* 账户信息 - 查询当前用户的所有账户ID及其相关信息
```
    GET "https://api.huobi.pro/v1/account/accounts"
    {
      "data": [
        {
          "id": 100001,
          "type": "spot",
          "subtype": "",
          "state": "working"
        }
        {
          "id": 100002,
          "type": "margin",
          "subtype": "btcusdt",
          "state": "working"
        },
        {
          "id": 100003,
          "type": "otc",
          "subtype": "",
          "state": "working"
        }
      ]
    }
```
    
*  账户余额 - spot:现货余额 ，margin:杠杆余额 ，otc:OTC余额 ，point:点卡余额
```
    GET "https://api.huobi.pro/v1/account/accounts/{account-id}/balance"
    {
      "data": {
        "id": 100009,
        "type": "spot",
        "state": "working",
        "list": [
          {
            "currency": "usdt",
            "type": "trade",
            "balance": "5007.4362872650"
          },
          {
            "currency": "usdt",
            "type": "frozen",
            "balance": "348.1199920000"
          }
        ],
        "user-id": 10000
      }
    }
```
    
* 资产划转(母子账号之间)
```
    GET "https://api.huobi.pro/v1/subuser/transfer"
    {
      "data":123456,
      "status":"ok"
    }
```
    
 * 子账号余额、子账号余额汇总
 

