import com.spring.service.IRemoteService;
import com.spring.service.RemoteServiceImp;
import org.redisson.Redisson;
import org.redisson.api.RRemoteService;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

public class Application {

    public static void main(String[] args){
        // 1. Create config object
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redissonClient = Redisson.create(config);
        RRemoteService remoteService = redissonClient.getRemoteService();
        IRemoteService service = new RemoteServiceImp();
        remoteService.register(IRemoteService.class, service);
    }
}
