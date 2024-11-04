package linzi.spring.restful.crud.common;

import lombok.Data;

/**
 * 通用响应类，用于包装返回的数据、状态码和信息。
 *
 * @param <T> 泛型参数，表示返回的数据类型。
 */
@Data
public class R<T> {

    /**
     * 状态码，通常用于表示操作是否成功。
     */
    private Integer code;

    /**
     * 返回的信息，例如操作成功或错误的描述。
     */
    private String msg;

    /**
     * 返回的数据，可以是任意类型的对象。
     */
    private T data;

    /**
     * 成功操作的响应，带有数据。
     *
     * @param data 返回的数据
     * @param <T> 泛型参数，表示返回的数据类型
     * @return 包含成功状态码、信息和数据的响应对象
     */
    public static <T> R<T> ok(T data) {
        R<T> r = new R<T>();
        r.setCode(200);
        r.setMsg("ok");
        r.setData(data);
        return r;
    }

    /**
     * 成功操作的响应，不带数据。
     *
     * @param <T> 泛型参数，表示返回的数据类型
     * @return 包含成功状态码和信息的响应对象
     */
    public static <T> R<T> ok() {
        R<T> r = new R<>();
        r.setCode(200);
        r.setMsg("ok");
        r.setData(null);
        return r;
    }

    /**
     * 错误操作的响应，不带数据。
     *
     * @param <T> 泛型参数，表示返回的数据类型
     * @return 包含错误状态码和信息的响应对象
     */
    public static <T> R<T> error() {
        R<T> r = new R<T>();
        r.setCode(500);
        r.setMsg("error");
        r.setData(null);
        return r;
    }

    /**
     * 错误操作的响应，带有自定义状态码和信息。
     *
     * @param code 状态码
     * @param msg 返回的信息
     * @param <T> 泛型参数，表示返回的数据类型
     * @return 包含错误状态码和信息的响应对象
     */
    public static <T> R<T> error(Integer code, String msg) {
        R<T> r = new R<T>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    /**
     * 错误操作的响应，带有自定义状态码、信息和数据。
     *
     * @param code 状态码
     * @param msg 返回的信息
     * @param data 返回的数据
     * @param <T> 泛型参数，表示返回的数据类型
     * @return 包含错误状态码、信息和数据的响应对象
     */
    public static <T> R<T> error(Integer code, String msg, T data) {
        R<T> r = new R<T>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

}
