import com.spring.service.IRemoteService;
import org.redisson.Redisson;
import org.redisson.api.RRemoteService;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger logger
            = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws InterruptedException {
        // 1. Create config object
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redissonClient = Redisson.create(config);
        RRemoteService remoteService = redissonClient.getRemoteService();
        IRemoteService service = remoteService.get(IRemoteService.class);
        int cnt = 0;
        while(cnt++ < 100) {
            logger.info(service.HelloWorld("xiaji"));
            Thread.sleep(1000);
        }
    }
}
