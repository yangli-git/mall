package cn.edu.whpu.utils;

public class AlipayConfig {
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016102300743259";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC1YZkuxBeX5wR1O1bQhHUbQ4aFZn4rG07p1gisN84sPZSjxZ1o/f8JlWWPJ8xCdPAfq6CNh+cZxJDk2hvQGGrVsipZFTZqp7LvnFEk0FOiTd1wXVBT9WZANS3+6GaOY5FFmB/N0SrOYLTjeu3Uohf2CxKpEfiGJiq7chMfDIV4yf7yEPgrnCzMRugiPdSmCMsH2A8ljaBjo7T7KiiwEm/n76LY+7f1GkaujNE4MUvR7cm4rhRO5ulc47iDQWP6VSIKlXbOm9L4xBbDkXnhNkY3ts6CYxzZ2uegXzWxG3HyLiZeGBGEinuM79rkTW5zO/KwNLeELBSz9HkaewflDo1BAgMBAAECggEAKbozSGv6VYrjHqkxFrVyT3xgZS4oFnio1ejUg/Iur0TXfjnHNdFBLA4/mAh62EsYtuCABi9evjHXd56pyVzkrxbW4TmdFDpSUwduL37xzqQFLoV5JmeNR3Y0h7Elbtp/IDiYEHxvUZ0z4CV2s3U69/KiL10gBJShPhBHT9xMlHXXqBJ8ZTObxt68+VBpeMAXTdEZJkKstPkc7CtFBcCzpQ5AbQMN00axiaA2kxApHHu2G953rzW9MaLQDMVYqzZi6VmMk31zG1O3vTSeMY8gp2zGU50MSYgUfGH7XzzITWj5hxYZnOe43gMIrX7sSIVhTs2SjaXugjV25lg0WLkL8QKBgQD7iFx0aLRl2U6I/qRec2znL3S8sIyI2TFTHUFawl6dpJRORUGAAtA6Wq+CkLZk3ZWf09lPBhoW27SjfiCp8IlG/o6LE4Xh7S5oMF9byuNljnJpjiVP4iIcKXy7qlQTTX84BSaXNZl9/YVoSgzv9NSYKyrmTBcjUccp/CS8+ZdB7QKBgQC4mkf071/oUptk/wCH6+no8NCNRJlDSTbwVkpzRkoIQxY7i3ecVzTlFSEjECnJwXoPyVk35smFeq4/OJ61CWv8vSHnCzYolskg80J++CD0R7Zu1F1Q+TW2c/B0eG/dehgRtvcRspJIXAVBTVMXJiIL0QpnznpgNNM/d3XynFFeJQKBgQD6kro/wTrNJ3EEKmCGMwhvOihZ/KrTfUKU4NUFXBIziwuu+XEp3COhrkufjxgUXWW75aha/+InmVFXecOCZ7vpvJc11woNqmELq/yjDfgAaKpzmwZykPyX/4Bh12mQHSi6Hu91vRCeoVswLGy88rKCsKY469408jetDKFwnFfhdQKBgDqBGsDzhC+6zmjJsD9jcvRSLaY30WLTt0ef8WRrKFdJ+6fPYY74zFi1w5S7MKMyYB7UryPaTo+w+7wpk5LIc6LbxfzVPsrKTt/UeISI2tjQSW8CeriI4o76W4BuEvXcFfi3RcIkF9w63ad+fBDgEvYvv956P6px02lP0N+czuTJAoGBAPq85ym7xCKSJHUqOtB9XUlrBcYvaCSy7zIiboMMxKEphQYWXkRCxVDqgiMSUXE1DRuwjmR+ywl/790WRoNHKB6xFvnS9901OZvM8XSgNbYLxF2dWzWfVPiiCbsiG0dPBUKmTL84z8tHIdrwSstQ58G34/tQ0PEDdzZG+VeXE0+w";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhKQPq89OfcV8HFeIjd4DuY6FqW1p9l4NPh38YuVmdPvPgt5v2DWOc7Du3wbTW8ZWrn7mUZnpoLtOXZWxw9ZeVoTepvBvUOZL7CyulVUXpOnL33AvsS68pWcaU55e7b0N37qBsdyz3KVsAhDhflBaqVVKCR4jOQ+9z2KTFBAUvvKgft5CvL7CnCWweG2k6i2P7gH9xCfPtmqI6T0sVhEsFLCnXCCDCl4mnibCes7Mdjt0DDQeOQZC41zsfAqmgvt3IZ+33/PUtAo7mFxIMfBbs/0pKE0MLI2z7RPORUIceR7+idZDY5y9i1gXRjtgbo6+mTOoYAIcPDJJiX51jhzW3QIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://120.76.142.145:8080/pay/alipayNotifyNotice";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //当支付成功之后，通知我们服务（服务器必须定义一个servlet或jsp来接收apli的通知）
    public static String return_url = "http://120.76.142.145/pay/alipayReturnNotice";

    // 签名方式
    public static String sign_type = "RSA2";

    // 返回格式
    public static String FORMAT = "json";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关日志
    public static String log_path = "F:\\支付资料\\alipay支付宝\\log";
}
