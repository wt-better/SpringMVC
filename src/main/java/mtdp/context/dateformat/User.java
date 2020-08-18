package mtdp.context.dateformat;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author wangte
 * @date created at 2018/11/3
 */
@Data
public class User {

    private String name;

    private String sex;

    private int age;

    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private Long birthday;

    private boolean isNew;

    private String isStr;

    private boolean newA;
}
