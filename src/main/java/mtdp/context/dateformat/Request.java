package mtdp.context.dateformat;

import lombok.Data;

import java.util.List;

/**
 * @author wangte
 * @date created at 2018/11/22
 */
@Data
public class Request {

    String name;

    List<Long> ids;
}
