package wang.leisure.rpc.common.protocol;

/**
 * 响应状态码
 *
 * @author 东方雨倾
 * @since 1.0.0
 */
public enum LeisureStatus {
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "ERROR"),
    NOT_FOUND(404, "NOT FOUND");

    private int code;

    private String message;

    LeisureStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
