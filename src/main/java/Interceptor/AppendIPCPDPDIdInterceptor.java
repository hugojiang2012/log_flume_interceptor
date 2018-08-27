package Interceptor;


import java.nio.charset.Charset;
import  java.util.List;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;
import com.google.common.base.Charsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import parquet.format.event.EventBasedThriftReader;

/*
 * Created by Administrator on 2018/7/3.
 * 追加设备IP/设备角色（CP或者DP）/设备的Id的拦截器
*/


public class AppendIPCPDPDIdInterceptor implements Interceptor{
    private static final Logger logger = LoggerFactory.getLogger(AppendIPCPDPDIdInterceptor.class);
    private String serviceIp = null;
    private String serviceRole = null;
    private String serviceId = null;

    public AppendIPCPDPDIdInterceptor(String _serviceIp, String  _serviceRole,  String _serviceId){
        serviceIp = _serviceIp;
        serviceRole = _serviceRole;
        serviceId = _serviceId;

    }
    public Event intercept(Event arg0){
        String eventBody = new String(arg0.getBody(), Charsets.UTF_8);
        logger.error("jiangjinping");
        String fmt ="%s---%s---%s---%s";
        logger.error("jiangjinping" + serviceIp + " " + serviceRole + " " + serviceId);
        arg0.setBody(String.format(fmt,serviceIp, serviceRole, serviceId, eventBody).getBytes());
        return arg0;
    }

    public List<Event>intercept(List<Event> events){
        for(Event event: events){
            intercept(event);
        }
        return events;
    }

    public void close(){
        //
    }

    public void initialize(){
        //
    }
    public  static class AppendIPCPDPIdBuilder implements  Interceptor.Builder {
        private String serviceIp = null;
        private String serviceRole = null;
        private String serviceId = null;

        public void configure(Context context){
            String configserviceIp = context.getString("serviceIp");
            String configserviceRole = context.getString("serviceRole");
            String configserviceId = context.getString("serviceId");
            serviceIp = configserviceIp;
            serviceRole = configserviceRole;
            serviceId = configserviceId;
        }
        public Interceptor build(){
            return new AppendIPCPDPDIdInterceptor(serviceIp, serviceRole, serviceId);
        }
    }
}


