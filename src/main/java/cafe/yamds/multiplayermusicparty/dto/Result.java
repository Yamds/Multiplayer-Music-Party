package cafe.yamds.multiplayermusicparty.dto;

/**
 * DTO：数据传输对象
 * 统一返回结果，对于任何业务操作返回都是这个对象
 */
public class Result<T> {
    /** 状态码 */
    private int code;
    /** 说明消息 */
    private String msg;
    /** 结果数据 */
    private T data;

    public Result() {
    }

    public Result(int code) {
        this.code = code;
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
