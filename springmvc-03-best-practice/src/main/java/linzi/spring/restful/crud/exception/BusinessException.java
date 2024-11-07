package linzi.spring.restful.crud.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 大型系统会出现以下异常:
 * <p>
 * 订单模块（1xxxx）：
 * 10001：订单已关闭
 * 10002：订单不存在
 * 10003：订单超时
 * 10004：订单无法取消
 * 10005：订单已支付
 * <p>
 * 商品模块（2xxxx）：
 * 20001：商品已下架
 * 20002：商品库存不足
 * 20003：商品不存在
 * 20004：商品价格已变动
 * 20005：商品详情获取失败
 * <p>
 * 用户模块（3xxxx）：
 * 30001：用户不存在
 * 30002：用户未登录
 * 30003：用户权限不足
 * 30004：用户账号已锁定
 * 30005：用户信息更新失败
 * <p>
 * 支付模块（4xxxx）：
 * 40001：支付失败
 * 40002：支付超时
 * 40003：支付金额不符
 * 40004：支付方式不支持
 * 40005：支付取消
 * <p>
 * 物流模块（5xxxx）：
 * 50001：物流信息不存在
 * 50002：物流更新失败
 * 50003：物流已发出
 * 50004：物流延迟
 * 50005：物流配送失败
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {

    private Integer code;

    private String msg;

    public BusinessException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(BusinessExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMsg());
        this.code = exceptionEnum.getCode();
        this.msg = exceptionEnum.getMsg();
    }

}
