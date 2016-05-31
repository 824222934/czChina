package core;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		JedisPool pool = new JedisPool(new JedisPoolConfig(),"Localhost");
		Jedis jedis = null;
		try {
			jedis = pool.getResource();
			jedis.set("foo","bar");
			String foobar = jedis.get("foo");
			jedis.zadd("sose",0, "car");
			jedis.zadd("sose",0, "bike");
			Set<String> sose = jedis.zrange("sose", 0, -1);
		}finally{
			if(jedis != null){
				jedis.close();
			}
		}
		pool.destroy();
	}
}
