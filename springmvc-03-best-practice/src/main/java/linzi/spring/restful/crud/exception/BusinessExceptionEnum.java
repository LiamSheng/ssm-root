package linzi.spring.restful.crud.exception;

import lombok.Getter;

@Getter
public enum BusinessExceptionEnum {

    // 订单模块（1xxxx）
    ORDER_CLOSED(10001, "订单已关闭"),
    ORDER_NOT_FOUND(10002, "订单不存在"),
    ORDER_TIMEOUT(10003, "订单超时"),
    ORDER_CANNOT_CANCEL(10004, "订单无法取消"),
    ORDER_PAID(10005, "订单已支付"),

    // 商品模块（2xxxx）
    PRODUCT_OFF_SHELF(20001, "商品已下架"),
    PRODUCT_OUT_OF_STOCK(20002, "商品库存不足"),
    PRODUCT_NOT_FOUND(20003, "商品不存在"),
    PRODUCT_PRICE_CHANGED(20004, "商品价格已变动"),
    PRODUCT_DETAILS_FAIL(20005, "商品详情获取失败"),

    // 用户模块（3xxxx）
    USER_NOT_FOUND(30001, "用户不存在"),
    USER_NOT_LOGGED_IN(30002, "用户未登录"),
    USER_PERMISSION_DENIED(30003, "用户权限不足"),
    USER_ACCOUNT_LOCKED(30004, "用户账号已锁定"),
    USER_UPDATE_FAIL(30005, "用户信息更新失败"),

    // 支付模块（4xxxx）
    PAYMENT_FAIL(40001, "支付失败"),
    PAYMENT_TIMEOUT(40002, "支付超时"),
    PAYMENT_AMOUNT_MISMATCH(40003, "支付金额不符"),
    PAYMENT_METHOD_UNSUPPORTED(40004, "支付方式不支持"),
    PAYMENT_CANCELLED(40005, "支付取消"),

    // 物流模块（5xxxx）
    LOGISTICS_NOT_FOUND(50001, "物流信息不存在"),
    LOGISTICS_UPDATE_FAIL(50002, "物流更新失败"),
    LOGISTICS_SHIPPED(50003, "物流已发出"),
    LOGISTICS_DELAYED(50004, "物流延迟"),
    LOGISTICS_DELIVERY_FAIL(50005, "物流配送失败");

    private final Integer code;
    private final String msg;

    BusinessExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
