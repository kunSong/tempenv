package org.songkun.demo;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.sun.mail.pop3.POP3SSLStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import javax.xml.parsers.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);

//		int[] ns = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
//		System.out.println(Arrays.toString(ns));
//		Arrays.sort(ns);
//		sort(ns);
//		System.out.println(Arrays.toString(ns));

//		Income income1 = new IncomeAndBookcomeTex(1000, 3000);
//		System.out.println(income1.getTex());
//		System.out.println(IncomeAndBookcomeTex.count);

//		System.out.println("equalsIgnoreCase " + "abc".equalsIgnoreCase("Abc"));
//		System.out.println("isEmpty " + " \n".isEmpty());
//		String s = "my name %s";
//		System.out.println(String.format(s, "songkun"));

//		String[] fields = { "name", "position", "salary" };
//		String table = "employee";
//		String insert = buildInsertSql(table, fields);
//		System.out.println(insert);

//		String[] names = {"bob", "alice", "nicky"};
//		StringBuilder builder = new StringBuilder();
//		for(String name : names) {
//			builder.append(name).append(",");
//		}
//		System.out.println(builder.toString().trim());
//		builder.delete(builder.length() - 1, builder.length());
//		builder.append("!");
//		System.out.println(builder.toString().trim());

//		String[] fields = { "name", "position", "salary" };
//		String table = "employee";
//		String select = buildSelectSql(table, fields);
//		System.out.println(select);

//		Person person = new Person();
//		person.setName("songkun");
//		person.setAge(34);
//		try {
//			BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
//
//			for(PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors()) {
//				System.out.println(descriptor.getPropertyType() + " " + descriptor.getName());
//				descriptor.setPropertyEditorClass(StringEditor.class);
//				if(descriptor.getName().equalsIgnoreCase("name")) {
//					PropertyEditor propertyEditor = descriptor.createPropertyEditor(person);
//					propertyEditor.addPropertyChangeListener(new PropertyChangeListener() {
//						@Override
//						public void propertyChange(PropertyChangeEvent evt) {
//							System.out.println(evt.getOldValue() + " " + evt.getNewValue());
//						}
//					});
//				}
//			}
//		} catch (IntrospectionException e) {
//			e.printStackTrace();
//		}
//		person.setName("songchenyan");

        //??????????????????????????????????????????BigInteger???????????????scale????????????????????????Number
//		BigDecimal b1 = new BigDecimal("123.400");
//		System.out.println(b1.scale()); // 3?????????
//		BigDecimal b1Zero = b1.stripTrailingZeros(); // ????????????0
//		System.out.println(b1Zero.scale()); // ??????1?????????
//
//		BigDecimal b2 = new BigDecimal("123000");
//		BigDecimal b2Zero = b2.stripTrailingZeros();
//		System.out.println(b2.scale()); // 0?????????????????????
//		System.out.println(b2Zero.scale()); // ????????????0?????????-3???????????????????????????3???0
//
//		BigDecimal d1 = new BigDecimal("123.456789");
//		BigDecimal d2 = d1.setScale(4, RoundingMode.HALF_UP); // ???????????????123.4568
//		BigDecimal d3 = d1.setScale(4, RoundingMode.DOWN); // ???????????????123.4567
//		System.out.println(d2);
//		System.out.println(d3);
//
//		BigDecimal d4 = new BigDecimal("123.456");
//		BigDecimal d5 = new BigDecimal("23.456789");
//		BigDecimal d6 = d4.divide(d5, 10, RoundingMode.HALF_UP); // ??????10????????????????????????
//		BigDecimal d7 = d4.divide(d5); // ?????????ArithmeticException??????????????????
//
//		BigDecimal n = new BigDecimal("12.345");
//		BigDecimal m = new BigDecimal("0.12");
//		BigDecimal[] dr = n.divideAndRemainder(m);
//		System.out.println(dr[0]); // 102 ???
//		System.out.println(dr[1]); // 0.105 ??????
//
        // ?????? BigDecimal extends Number implements Comparable<BigDecimal>
//		BigDecimal d8 = new BigDecimal("123.456");
//		BigDecimal d9 = new BigDecimal("123.45600");
//		System.out.println(d8.equals(d9)); // false,??????scale??????
//		System.out.println(d8.equals(d9.stripTrailingZeros())); // true,??????d8????????????0???scale??????2
//		System.out.println(d8.compareTo(d9)); // 0

//		ExceptionSurpress e = new ExceptionSurpress();
//		System.out.println(e.process1());
//		e.process2();

//		assertTest();

//		JDKLogTest();
//		commonsLog();
//		slf4jLog();

//		reflectTest();

//		collectionListTest1();
//		collectionListTest2();
//		collectionMap1();
//		collectionTreeMap();
//		dupMessage();
//		toHex();
//		calculatorExpression();
//		unmodifiableCollection();

//		List<File> files = listFiles(new File("."), new FileFilter() {
//			@Override
//			public boolean accept(File pathname) {
//				if(pathname.isDirectory()) {
//					return true;
//				}
//				if(pathname.getName().endsWith(".java")) {
//					System.out.println(pathname);
//					return true;
//				}
//				return false;
//			}
//		}, new LinkedList<>());
//		for (File file : files) {
//			System.out.println(file);
//		}
//		MockFileTest();
//      copyFileTest();
//		extensionFileInputStreamTest();

//		zonedDateTime();
//		testArriveTime();

//		System.out.println(Factorial.fact(20));
//		System.out.println(StringUtilss.capitalize("APPLE"));

//		regexp();
//		myTemplateEngine();

//		messageDigest();

//		try {
//			UDPServer();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		try {
//			receiveJavaEmail();
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		stringTokenizerTest();

//		try {
//			rmiServer();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		} catch (AlreadyBoundException e) {
//			e.printStackTrace();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

//		try {
//			resolveXMLByDOM();
//		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SAXException e) {
//			e.printStackTrace();
//		}

//		try {
//			resovleXMLBySAX();
//		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//		} catch (SAXException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		try {
//			resolveXMLByJackson();
//		} catch (IOException e) {
//			e.printStackTrace();
//    }

//        try {
//            resolveJsonByJackson();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//		try {
//			serialObjectToJsonByJackson();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		ignoreCaseNameSorting();
//		ignoreCaesNameSorting2();
//		try {
//			createStream();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		mapStream();
//		filterStream();
//		try {
//			reduceStream();
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		collectOutput();

//		try {
//			runCallable();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

//		buildXMLTree();

//		MDataSource mDataSource = PooledMDataSourceProxy.newInstance();
//		try(MConnection connection = mDataSource.getConnection()){
//			System.out.println(connection.getName());
//			connection.preparedStatement("select 1");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try(MConnection connection = mDataSource.getConnection()){
//			System.out.println(connection.getName());
//			connection.preparedStatement("select 2");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		try {
//			mDataSource.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//        Invoker invoker = new Invoker();
//        invoker.registHandler(new InfoHandler());
//        invoker.registHandler(new DebugHandler());
//        invoker.registHandler(new ErrorHandler());
//        invoker.handle(invoker, null);

//		try {
//			testIOinMultiThread();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		TextEditor textEditor = new TextEditorImpl();
//		Command copy = new CommandFactory(textEditor)
//				.createCommand("copy")
//				.setOffset(0)
//				.setEnd(4)
//				.build();
//		copy.execute();
//		System.out.println(ClipBooard.getInstance().getClipBoard());
//		Command paste = new CommandFactory(textEditor)
//				.createCommand("paste")
//				.setOffset(-1)
//				.build();
//		paste.execute();
//		textEditor.save();

//		MarketService marketService = new MarketService();
//		marketService.enableDouble11();
//		marketService.setStrategty("normal");
//		System.out.println("?????? " + marketService.getFinalPrice(BigDecimal.valueOf(101)).toString());

//		AbstractSettings settings = new GuavaCache();
//		System.out.println(settings.getSettings("server.port"));
//		System.out.println(settings.getSettings("server.port"));

	}

	static abstract class AbstractSettings {
		String getSettings(String key) {
			String settings = null;
			settings = lookupCache(key);
			if(settings == null) {
				settings = readFromDB(key);
			}
			updateCache(key, settings);
			return settings;
		}

		public String readFromDB(String key) {
			System.out.println("readFromDB");
			return "8888";
		}

		public abstract String lookupCache(String key);

		public abstract void updateCache(String key, String value);
	}

	static class LocalCache extends AbstractSettings {
		private Map<String, String> cache = new HashMap<>();

		@Override
		public String lookupCache(String key) {
			return cache.get(key);
		}

		@Override
		public void updateCache(String key, String value) {
			cache.put(key, value);
		}
	}

	static class GuavaCache extends AbstractSettings {
		private Cache<String, String> cache;

		public GuavaCache() {
			cache = CacheBuilder.newBuilder()
					.initialCapacity(1)
					.expireAfterAccess(Duration.ofSeconds(2L))
					.maximumSize(10)
					.build();
		}

		@Override
		public String lookupCache(String key) {
			return cache.getIfPresent(key);
		}

		@Override
		public void updateCache(String key, String value) {
			cache.put(key, value);
		}
	}

	static class RedisCache extends AbstractSettings {
		private JedisPool pool = new JedisPool("139.224.205.90", 6379);

		@Override
		public String lookupCache(String key) {
			try(Jedis jedis = pool.getResource()){
				return jedis.get(key);
			}
		}

		@Override
		public void updateCache(String key, String value) {
			try(Jedis jedis = pool.getResource()){
				jedis.set(key, value);
			}
		}
	}


	public interface DiscountStrategy {
		BigDecimal getDiscount(BigDecimal total);
	}

	static class MarketService {
		private DiscountStrategy strategy;
		private DiscountStrategy extensionStrategy;
		public void setStrategty(String userType) {
			if(userType.equalsIgnoreCase("normal")) {
				strategy = new NormalDiscountStrategy(extensionStrategy);
			} else if(userType.equalsIgnoreCase("prime")) {
				strategy = new PrimeDiscountStrategy(extensionStrategy);
			}
		}
		private void startExtensionStrategy() {
			this.extensionStrategy = new OverDiscountStrategy();
		}
		public void enableDouble11() {
			startExtensionStrategy();
		}
		public BigDecimal getFinalPrice(BigDecimal total) {
			BigDecimal discount = strategy.getDiscount(total);
			BigDecimal finalPrice = total.subtract(discount).setScale(2, BigDecimal.ROUND_DOWN);
			return finalPrice;
		}
	}

	static class NormalDiscountStrategy implements DiscountStrategy {
		private DiscountStrategy delegate;
		public NormalDiscountStrategy() {

		}
		public NormalDiscountStrategy(DiscountStrategy delegate) {
			this.delegate = delegate;
		}
		@Override
		public BigDecimal getDiscount(BigDecimal total) {
			BigDecimal discount = BigDecimal.ZERO;
			if(delegate != null) {
				discount = delegate.getDiscount(total);
			}
			// do something more discount
			return total.subtract(discount).multiply(BigDecimal.valueOf(0.1)).add(discount);
		}

		public void setDelegate(DiscountStrategy delegate) {
			this.delegate = delegate;
		}
	}

	static class PrimeDiscountStrategy implements DiscountStrategy {
		private DiscountStrategy delegate;
		public PrimeDiscountStrategy() {

		}
		public PrimeDiscountStrategy(DiscountStrategy delegate) {
			this.delegate = delegate;
		}
		@Override
		public BigDecimal getDiscount(BigDecimal total) {
			BigDecimal discount = BigDecimal.ZERO;
			if(delegate != null) {
				discount = delegate.getDiscount(total);
			}
			// do something more discount
			return total.subtract(discount).multiply(BigDecimal.valueOf(0.3)).add(discount);
		}

		public void setDelegate(DiscountStrategy delegate) {
			this.delegate = delegate;
		}
	}

	static class OverDiscountStrategy implements DiscountStrategy {

		@Override
		public BigDecimal getDiscount(BigDecimal total) {
			if(total.intValue() < 100) {
				return BigDecimal.ZERO;
			}
			return BigDecimal.valueOf(20);
		}
	}

    public static void testIOinMultiThread() throws IOException {
		CyclicBarrier cb = new CyclicBarrier(500);
		// final FileOutputStream fo = new FileOutputStream("book.txt");
		final FileWriter fw = new FileWriter("book.txt");
		for (int i = 0; i < 500; i++) {
			final int index = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						cb.await();
						// native writeBytes ???????????? ?????????
//						fo.write(new String("book " + index + "\n").getBytes());
//						fo.write(new String("book more " + index + "\n").getBytes());
						// filewrite ????????????????????????????????????????????? ???????????????????????????????????????
						// ??????????????????????????????????????????
						fw.write("book " + index + "\n");
						fw.write("book more " + index + "\n");
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

	// TextEditor??????????????????????????????
    static class CommandFactory {
	    private TextEditor textEditor;
	    private Command command;
	    private String content;
	    private int offset = -1;
	    private int end = -1;
	    public CommandFactory(TextEditor textEditor) {
	    	this.textEditor = textEditor;
		}

        public CommandFactory createCommand(String type) {
	        switch (type) {
                case "copy":
                	command = new CopyCommand(textEditor);
                    break;
                case "paste":
					command = new PasteCommand(textEditor);
                    break;
				case "delete":
					command = new CopyCommand(textEditor);
					break;
				case "add":
					break;
                case "save":
                    break;
                case "undo":
                    break;
                default:
                    break;
            }
            return this;
        }

        public CommandFactory setContent(String content) {
	    	this.content = content;
	    	return this;
		}

		public CommandFactory setOffset(int offset) {
	    	if(offset < -1) {
	    		throw new IllegalArgumentException("offset over range");
			}
	    	this.offset = offset;
	    	return this;
		}

		public CommandFactory setEnd(int end) {
	    	if(end < -1) {
				throw new IllegalArgumentException("offset over range");
			}
	    	if(this.offset > 0 && end != -1 && end < this.offset) {
				throw new IllegalArgumentException("end over range");
			}
	    	this.end = end;
	    	return this;
		}

		public Command build() {
	    	if(command == null) {
	    		throw new IllegalStateException("please create command");
			}
	    	if(this.content != null) {
				command.setContent(content);
			}
	    	command.setOffset(offset);
	    	command.setEnd(end);
	    	return command;
		}

    }

    static abstract class AbstractCommand implements Command {
        protected final TextEditor textEditor;
        private String content;
        private int offset;
        private int end;
        private boolean undo = false;

	    private AbstractCommand(TextEditor textEditor) {
	        this.textEditor = textEditor;
        }

        @Override
        public void execute() {
            doExecute();
	        undo = true;
        }

        protected abstract void doExecute();

        @Override
        public void undo() {
	        if(undo) {
	            return;
            }
            this.textEditor.undo();
	        undo = true;
        }

        @Override
        public int getOffset() {
            return offset;
        }

		@Override
		public void setOffset(int offset) {
			this.offset = offset;
		}

		@Override
		public int getEnd() {
			return end;
		}

		@Override
		public void setEnd(int end) {
			this.end = end;
		}

        @Override
		public String getContent() {
			return content;
		}

		@Override
		public void setContent(String content) {
			this.content = content;
		}
    }

    static class CopyCommand extends AbstractCommand {

		public CopyCommand(TextEditor textEditor) {
			super(textEditor);
		}

		@Override
		protected void doExecute() {
			this.textEditor.copy(this);
			ClipBooard.getInstance().setClipBoard(this.getContent());
		}

		@Override
		public void undo() {
			throw new UnsupportedOperationException();
		}
	}

	static class PasteCommand extends AbstractCommand {

		public PasteCommand(TextEditor textEditor) {
			super(textEditor);
		}

		@Override
		protected void doExecute() {
			this.setContent(ClipBooard.getInstance().getClipBoard());
			this.textEditor.paste(this);
		}
	}

	static class DeleteCommand extends AbstractCommand {

		public DeleteCommand(TextEditor textEditor) {
			super(textEditor);
		}

		@Override
		protected void doExecute() {
			this.textEditor.delete(this);
		}
	}

	static class AddCommand extends AbstractCommand {

		public AddCommand(TextEditor textEditor) {
			super(textEditor);
		}

		@Override
		protected void doExecute() {
			this.textEditor.add(this);
		}
	}

    public interface Command {
	    void execute();
        void undo();
        String getContent();
		void setContent(String content);
        int getOffset();
		void setOffset(int offset);
		int getEnd();
		void setEnd(int end);
    }

    public interface TextEditor {
	    void copy(Command command);
	    void paste(Command command) throws IllegalArgumentException;
	    void add(Command command);
	    void delete(Command command);
	    void undo();
	    void redo();
	    void save();
    }

    static class ClipBooard {
	    private ClipBooard() {}
	    private static final ClipBooard INSTANCE = new ClipBooard();
	    private StringBuilder clipBoard = new StringBuilder();

	    public static ClipBooard getInstance() {
	        return INSTANCE;
        }

	    public String getClipBoard() {
	        return clipBoard.toString().trim();
        }

        public void setClipBoard(String content) {
	        clipBoard.delete(0, clipBoard.length());
	        clipBoard.append(content);
        }
    }

    static class TextEditorImpl implements TextEditor {
        private StringBuilder builder = new StringBuilder("songkun");
        private Deque<Command> undolog = new LinkedList<>();
        private List<Command> redolog = new LinkedList<>();
        private int checkpoint;

        @Override
        public void copy(Command command) {
            if(command.getOffset() > builder.length()) {
            	throw new IllegalArgumentException("copy over range");
			}
            command.setContent(builder.substring(command.getOffset(), command.getEnd()));
        }

        @Override
        public void paste(Command command) throws IllegalArgumentException {
            if(command.getOffset() > builder.length()) {
                throw new IllegalArgumentException("paste over range");
            }
            if(command.getOffset() == -1) {
            	command.setOffset(builder.length());
			}
            builder.insert(command.getOffset(), command.getContent());
			commit(command);
        }

        @Override
        public void add(Command command) {
            // insert
        }

        @Override
        public void delete(Command command) {
            // delete
        }

        @Override
        public void undo() {
            if(undolog.isEmpty()) {
                return;
            }
            Command command = undolog.pollFirst();
            if(command instanceof PasteCommand) {
            	builder.delete(command.getOffset(), command.getContent().length());
			} else if(command instanceof DeleteCommand) {

			} else if(command instanceof AddCommand) {

			}
            commit(command);
        }

        @Override
        public void redo() {
            ListIterator<Command> commandListIterator = redolog.listIterator(checkpoint);
            while(commandListIterator.hasNext()) {
                commandListIterator.next().execute();
            }
            //checkpoint = redolog.size();
        }

        @Override
        public void save() {
            System.out.println(builder.toString().trim());
            //checkpoint = redolog.size();
        }

        private void commit(Command command) {
            redolog.add(command);
            undolog.addFirst(command);
        }
    }

    public interface Handler {
	    void handle(Handler processor, InvokerContext context);
    }

    static class Invoker implements Handler{
        private CopyOnWriteArrayList<Handler> chain = new CopyOnWriteArrayList<>();

	    void registHandler(Handler handler) {
            chain.add(handler);
        }

        @Override
        public void handle(Handler processor, InvokerContext context) {
            if(context == null) {
                context = new InvokerContext(Collections.unmodifiableList(chain));
            }
            Iterator<Handler> iterator = context.get();
            while(iterator.hasNext()) {
                iterator.next().handle(this, context);
            }
        }
    }

    static class InvokerContext implements AutoCloseable {
	    private final List<Handler> chain;
	    private ThreadLocal<Iterator<Handler>> tl = new ThreadLocal<Iterator<Handler>>() {
            @Override
            protected Iterator<Handler> initialValue() {
                return chain.iterator();
            }
        };
	    public InvokerContext(List<Handler> chain) {
	        this.chain = chain;
        }
        public Iterator<Handler> get() {
	        return tl.get();
        }
        @Override
        public void close() throws Exception {
            tl.remove();
        }
    }

    static class InfoHandler implements Handler {

        @Override
        public void handle(Handler processor, InvokerContext context) {
            System.out.println("before Info handle");
            //doHandle();
            processor.handle(processor, context);
            System.out.println("after Info handle");
        }

        private void doHandle() {
            System.out.println("Info Handle");
        }
    }

    static class DebugHandler implements Handler {

        @Override
        public void handle(Handler processor, InvokerContext context) {
            System.out.println("before debug handle");
            //doHandle();
            processor.handle(processor, context);
            System.out.println("after debug handle");
        }

        private void doHandle() {
            System.out.println("debug Handle");
        }
    }

    static class ErrorHandler implements Handler {

        @Override
        public void handle(Handler processor, InvokerContext context) {
            System.out.println("before error handle");
            //doHandle();
            processor.handle(processor, context);
            System.out.println("after error handle");
        }

        private void doHandle() {
            System.out.println("error Handle");
        }
    }

	public interface MDataSource {
		MConnection getConnection();
		void close() throws Exception;
	}

	public interface MConnection extends AutoCloseable {
		PreparedStatement preparedStatement(String sql);
		String getName();
	}

	// ?????????????????????????????????
	static class MDataSourceImpl implements MDataSource {
		// config
		private final MDataSource dataSource;
		private static int count;
		public MDataSourceImpl(MDataSource dataSource) {
			this.dataSource = dataSource;
		}
		@Override
		public MConnection getConnection() {
			return new MConnectionProxy(dataSource, "connect-" + count++);
		}

		@Override
		public void close() {
			// do nothing
		}
	}

	static class MConnectionImpl implements MConnection {
		private boolean socket = false;

		@Override
		public PreparedStatement preparedStatement(String sql) {
			try {
				if(!socket) {
					openConnection();
				}
				System.out.println("process sql ..." + sql);
				System.out.println("create preparedStatement ...");
				System.out.println("return preparedStatement ... ");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public String getName() {
			return null;
		}

		private void openConnection() throws IOException {
			//socket = new Socket("localhost", 6666);
			System.out.println("open connection success");
			socket = true;
		}

		@Override
		public void close() throws Exception {
			//try {
				System.out.println("socket close");
			//} catch (IOException e) {
			//	e.printStackTrace();
			//}
		}
	}

	static class MConnectionProxy implements MConnection, InvocationHandler {
		private MConnection target;
		private final MDataSource dataSource;
		private String name;

		public MConnectionProxy(MDataSource dataSource, String name) {
			System.out.println("MConnectionProxy constructor");
			this.dataSource = dataSource;
			this.name = name;
		}
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if(method.getName().equals("close") && target == null) {
				return null;
			}
			if(method.getName().equals("preparedStatement") && target == null) {
				target = new MConnectionImpl();
				System.out.println("create real MConnectionImpl");
			}
			return method.invoke(target, args);
		}

		@Override
		public PreparedStatement preparedStatement(String sql) {
			try {
				Method method = MConnection.class.getMethod("preparedStatement", String.class);
				invoke(this, method, new Object[]{sql});
			} catch (Throwable throwable) {
				throwable.printStackTrace();
			}
			return null;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public void close() {
			if(PooledMDataSourceProxy.isShutDown) {
				try {
					invoke(this, MConnection.class.getMethod("close"), null);
				} catch (Throwable throwable) {
					throwable.printStackTrace();
				}
			}else {
				if (dataSource instanceof PooledMDataSourceProxy) {
					((PooledMDataSourceProxy) dataSource).returnConnection(this);
				}
			}
		}

	}

	static class PooledMDataSourceProxy implements MDataSource, InvocationHandler {
		private final Deque<MConnection> pool; // ????????????
		public static boolean isShutDown = false;
		public static MDataSource newInstance() {
			return new PooledMDataSourceProxy();
		}
		private PooledMDataSourceProxy() {
			this.pool = new LinkedList<>();
		}

		private MDataSource dataSource;
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			if(dataSource == null) {
				dataSource = new MDataSourceImpl(this);
			}
			MConnection connection = (MConnection) method.invoke(dataSource);
			return connection;
		}

		@Override
		public MConnection getConnection() {
			MConnection conn = null;
			System.out.println("before poll " + pool.size());
			// ????????????????????????BlockingQueue???????????????????????????????????????????????????shutdown
			if(pool.isEmpty()) {
				try {
					Method method = MDataSource.class.getMethod("getConnection");
					conn = (MConnection) invoke(this, method, null);
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (Throwable throwable) {
					throwable.printStackTrace();
				}
				pool.addLast(conn);
			}
			MConnection connection = pool.pollFirst();
			System.out.println("after pool " + pool.size());
			return connection;
		}

		@Override
		public void close() throws Exception {
			isShutDown = true;
			System.out.println(pool.size());
			for (MConnection connection : pool) {
				connection.close();
			}
		}

		public void returnConnection(MConnection connection) {
			System.out.println("connect returned");
			pool.addLast(connection);
		}

	}

	static class BoldMNodeDecorator implements MNode {
		private MNode target;

		public BoldMNodeDecorator(MNode target) {
			this.target = target;
		}

		@Override
		public MNode addChild(MNode node) {
			throw new UnsupportedOperationException();
		}

		@Override
		public String toXml() {
			return "<b>\n" + target.toXml() + "\n</b>";
		}

		@Override
		public List<MNode> children() {
			throw new UnsupportedOperationException();
		}
	}

	static class ElementMNode implements MNode {
		private final List<MNode> children;
		private String name;

		public ElementMNode(String name) {
			this.children = new ArrayList<>();
			this.name = name;
		}

		@Override
		public MNode addChild(MNode node) {
			children.add(node);
			return this;
		}

		@Override
		public String toXml() {
			String start = "<" + name + ">\n";
			String end = "</" + name + ">";
			StringJoiner sj = new StringJoiner("", start, end);
			children.forEach(node -> {
				sj.add(node.toXml() + "\n");
			});
			return sj.toString();
		}

		@Override
		public List<MNode> children() {
			return Collections.unmodifiableList(children);
		}
	}

	public static void buildXMLTree() {
		ElementMNode document = new ElementMNode("document");
		document.addChild(new ElementMNode("div")
				.addChild(new ElementMNode("p")
					.addChild(new TextMNode("Vue"))));
		document.addChild(new ElementMNode("div")
				.addChild(new ElementMNode("p")
					.addChild(new TextMNode("Java"))));
		System.out.println(document.toXml());
		System.out.println(new BoldMNodeDecorator(document).toXml());
	}

	public interface MNode {
		MNode addChild(MNode node);
		String toXml();
		List<MNode> children();
	}

	static class TextMNode implements MNode {
		private String text;
		public TextMNode(String text) {
			this.text = text;
		}
		@Override
		public MNode addChild(MNode node) {
			throw new UnsupportedOperationException();
		}

		@Override
		public String toXml() {
			return text;
		}

		@Override
		public List<MNode> children() {
			return Collections.emptyList();
		}
	}

	static class FutureTask implements Runnable {
		private Callable<?> callable;
		private ExecutionException exception;
		private Object result;
		public FutureTask(Callable<?> call) {
			this.callable = call;
		}
		@Override
		public void run() {
			try {
				result = callable.call();
			} catch (Exception e) {
				exception = new ExecutionException(e);
			}
		}

		public Optional<Exception> getException() {
			return Optional.ofNullable(exception);
		}

		public Optional<Object> getResult() {
			return Optional.ofNullable(result);
		}
	}

	public static void runCallable() throws InterruptedException {
		FutureTask ft = new FutureTask(new MyTask());
		Thread thread = new Thread(ft);
		thread.start();
		thread.join();
		if(ft.getResult().isPresent()) {
			System.out.println(ft.getResult().get());
		} else {
			if(ft.getException().isPresent()) {
				System.out.println(ft.getException().get().getCause());
			}
			System.out.println("null");
		}
	}

	static class MyTask implements Callable<String> {

		@Override
		public String call() throws Exception {
			int i = 1/0;
			String songkun = StringUtils.reverse(null);
			return songkun;
		}
	}

	public static void collectOutput() {
		// collect Collector.toList
		List<String> list = Stream.of("songkun", "chenhuihui").collect(Collectors.toList());
		// toArray IntFunction ??????String[] apply ??????String
		String[] array = Stream.of("song", "chen").toArray(String[]::new);
		// ?????????map???????????????keyMapper???valueMapper??????????????????????????????
		Map<String, String> map = Stream.of("name=songkun", "age=34").collect(Collectors.toMap(
				s -> s.split("=")[0],
				s -> s.split("=")[1]
		));
		// ????????????
		Map<String, List<String>> group = Stream.of("songkun", "songchenyan", "chenhuihui")
				.collect(Collectors.groupingBy(
				s -> s.substring(0, 1),
				Collectors.toList()
		));
		System.out.println(group);
	}

	/*
	@FunctionalInterface
	public interface BinaryOperator<T> {
    	// Bi????????????????????????????????????
    	T apply(T t, T u);
	}
	*/
	public static void reduceStream() throws URISyntaxException, IOException {
		// identity 10 ????????????????????????????????????????????????????????????
		Integer reduce1 = Stream.of(1, 2).reduce(10, (acc, i) -> {
			return acc + i;
		});
		// ????????????????????????????????????Optional???????????????????????????NPE
		Optional<Integer> reduce2 = Stream.of(1, 2, 3).reduce((acc, i) -> {
			return acc + i;
		});
		// ??????map/reduce???????????????????????????Properties?????????
		// URI ??? URL ????????????????????? file:/xxx.xxx
		// ???map???????????????????????????
		// ??????files??????????????????try-with-resources????????????
		URL url = DemoApplication.class.getResource("/application.properties");
		Properties props = new Properties();
		try(Stream<String> lines = Files.lines(Paths.get(url.toURI()))) {
			lines.map((s) -> {
				String[] sp = s.split("=");
				Properties prop = new Properties();
				prop.setProperty(sp[0], sp[1]);
				return prop;
			}).reduce(props, (p, s) -> {
				((Properties)p).putAll(s);
				return p;
			});
		}
		System.out.println("props: " + props);
	}

	public static void filterStream() {
		Long count = Stream.generate(new LocalDateGenerator())
				.limit(31)
				.filter((d) -> d.getDayOfWeek() != DayOfWeek.SATURDAY && d.getDayOfWeek() != DayOfWeek.SUNDAY)
				.count();
		System.out.println(count);
				//.forEach(System.out::println);
	}

	static class LocalDateGenerator implements Supplier<LocalDate> {
		private LocalDate init = LocalDate.of(2022, 1, 1);
		private int n = 0;
		@Override
		public LocalDate get() {
			return init.plusDays(n++);
		}
	}

	public static void mapStream() {}

	public static void createStream() throws IOException {
		// 1. Stream.of
		Stream.of(1, 2, 3).forEach(System.out::println);
		// 2. Collection (List, Set, Queue)
		List<String> list = new ArrayList<>();
		list.add("songkun");
		list.add("chenhuihui");
		list.add("songchenyan");
		list.stream().forEach(System.out::println);
		Arrays.stream(new String[]{"wii", "ps4", "psp", "nds"}).forEach(System.out::println);
		// 3. Stream generateor ??????????????????get?????? ??????js python ??????generator?????? function *() { yield }
		// Stream?????????generator??????Supplier??????????????????
		LongStream.generate(new FibonacciGenerator()).limit(20).forEach(System.out::println);
		// 4. Files.line ?????????????????????Stream??????
		// java.nio.charset.MalformedInputException: Input length = 1 ????????????????????????????????????
		// lines?????????????????????????????????windows??????????????????GBK
		Files.lines(Paths.get("D:\\vue.txt"), Charset.forName("GBK")).forEach(System.out::println);
		// 5. ??????Stream??????????????????????????????????????????Stream<Integer>???????????????????????????????????????LongStream???IntStream??????
		IntStream stream = Arrays.stream(new int[]{1, 2, 3});
		LongStream longStream = Stream.of("1", "2", "3").mapToLong(Long::parseLong);
	}

	static class FibonacciGenerator implements LongSupplier {
		private long last = 0L; // ??????????????????Integer????????????null?????????0
		private long current = 0L;
		@Override
		public long getAsLong() {
			if(current == 0) {
				current++;
				return current;
			}
			long result = current + last;
			last = current;
			current = result;
			return result;
		}
	}

	public static void ignoreCaesNameSorting2() {
		String[] array = {"John", "Yan", "chenhuihui", "jiangyanping", "Tim"};
		Arrays.sort(array, DemoApplication::compareToIgnoreCase);
		System.out.println(Arrays.toString(array));
	}

	public static int compareToIgnoreCase(String s1, String s2) {
		return s1.compareToIgnoreCase(s2);
	}

	public static void ignoreCaseNameSorting() {
		String[] array = {"John", "Yan", "chenhuihui", "jiangyanping", "Tim"};
		Arrays.sort(array, (s1, s2) -> {
			return s1.compareToIgnoreCase(s2);
		});
		System.out.println(Arrays.toString(array));
	}

    // ???????????????
	public static void serialObjectToJsonByJackson() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Author author = new Author();
		author.firstName = "song";
		author.lastName = "kun";
		OutputStream out = new FileOutputStream("author.json");
		mapper.writeValue(out, author);
	}

	public static void resolveXMLByJackson() throws IOException {
		InputStream in = DemoApplication.class.getResourceAsStream("/book.xml");
		JacksonXmlModule module = new JacksonXmlModule();
		XmlMapper mapper = new XmlMapper(module);
		//mapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		Book book = mapper.readValue(in, Book.class);
		System.out.println(book);
	}

	// ??????BigInteger???????????????
	static class JsonToBigIntegerDes extends JsonDeserializer<BigInteger> {
		@Override
		public BigInteger deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
			return new BigInteger(jsonParser.getValueAsString().replace("-", ""));
		}
	}

	// ????????????Json?????????
	public static void resolveJsonByJackson() throws IOException {
		InputStream in = DemoApplication.class.getResourceAsStream("/book.json");
		// ????????????LocalDateTime ??????????????????jackson-datatype-jsr310 ?????????Module
		ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
		// ??????????????????properties
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
		BookJson book = mapper.readValue(in, BookJson.class);
		System.out.println(book);
	}

	static class Author {
		public String firstName;
		public String lastName;

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("Author{");
			sb.append("firstName='").append(firstName).append('\'');
			sb.append(", lastName='").append(lastName).append('\'');
			sb.append('}');
			return sb.toString();
		}
	}

	static class BookJson {
		public Long id;
		public long id2;
		public String name;
		public Author author;
		@JsonDeserialize(using = JsonToBigIntegerDes.class)
		public BigInteger isbn;
		public String lang;
		public List<String> tags;
		public LocalDate pubDate;

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("BookJson{");
			sb.append("id=").append(id);
			sb.append(", id2=").append(id2);
			sb.append(", name='").append(name).append('\'');
			sb.append(", author=").append(author);
			sb.append(", isbn=").append(isbn);
			sb.append(", lang='").append(lang).append('\'');
			sb.append(", tags=").append(tags);
			sb.append(", pubDate=").append(pubDate);
			sb.append('}');
			return sb.toString();
		}
	}

	static class Book {
		public Long id;
		public long id2;
		public String name;
		public String author;
		public String isbn;
		public String lang;
		public List<String> tags;
		public String pubDate;

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("Book{");
			sb.append("id=").append(id);
			sb.append(", id2=").append(id2);
			sb.append(", name='").append(name).append('\'');
			sb.append(", author='").append(author).append('\'');
			sb.append(", isbn='").append(isbn).append('\'');
			sb.append(", lang='").append(lang).append('\'');
			sb.append(", tags=").append(tags);
			sb.append(", pubDate='").append(pubDate).append('\'');
			sb.append('}');
			return sb.toString();
		}
	}

	public static void resovleXMLBySAX() throws ParserConfigurationException, SAXException, IOException {
		InputStream in = DemoApplication.class.getResourceAsStream("/book.xml");
		// ?????????????????????
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// ??????????????????
		SAXParser saxParser = factory.newSAXParser();
		saxParser.parse(in, new MyHandler());
	}

	static class MyHandler extends DefaultHandler {
		@Override
		public void startDocument() throws SAXException {
			System.out.println("start document");
		}

		@Override
		public void endDocument() throws SAXException {
			System.out.println("end document");
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			System.out.println("url " + uri + " localName " + localName + " qName " + qName + " attribute " + attributes.getValue(0));
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			System.out.println("uri " + uri + " localName " + localName + " qName " + qName);
		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			System.out.println(new String(ch, start, length).toString().trim());
		}

		@Override
		public void error(SAXParseException e) throws SAXException {
			System.out.println(e);
		}
	}

	public static void resolveXMLByDOM() throws ParserConfigurationException, IOException, SAXException {
		InputStream inputStream = DemoApplication.class.getResourceAsStream("/book.xml");
		// ?????????????????????????????????Factory??????????????????
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(inputStream);
		printDocumentElement(document); // document??????Node?????????
	}

	public static void printDocumentElement(Node node) {
		switch(node.getNodeType()) {
			case Node.DOCUMENT_NODE:
				System.out.println(node.getNodeName());
				break;
			case Node.ELEMENT_NODE:
				System.out.println(node.getNodeName());
				break;
			case Node.ATTRIBUTE_NODE:
				// id 1
				System.out.println(node.getNodeName() + " " + node.getNodeValue());
				break;
			case Node.TEXT_NODE:
				// #text Java????????????
				System.out.println(node.getNodeName() + " " + node.getNodeValue().toString().trim());
				break;
			default:
				break;
		}
		for(Node child = node.getFirstChild();child != null;child = child.getNextSibling()) {
			if(node.hasAttributes()) {
				// getAttributes??????NameNodeMap?????????list???item??????Node??????
				for (int i = 0; i < node.getAttributes().getLength(); i++) {
					printDocumentElement(node.getAttributes().item(i));
				}
			}
			printDocumentElement(child);
		}
	}

	public interface WorldClock extends Remote {
		LocalDateTime getLocalDateTime() throws RemoteException;
	}

	static class WorldClockImpl implements WorldClock {
		@Override
		public LocalDateTime getLocalDateTime() throws RemoteException {
			return LocalDateTime.now();
		}
	}

	public static void rmiServer() throws RemoteException, AlreadyBoundException, InterruptedException {
		WorldClock worldClock = new WorldClockImpl();
		// ????????????????????????????????????impl????????????????????????????????????
		// dubbo?????????????????????impl???bean???????????????ref??????bean?????????????????????????????????
		// rmi???????????????jdk??????????????????????????????????????????????????????????????????RPC???????????????????????????????????????
		// port 0 ???????????????
		Remote remote = UnicastRemoteObject.exportObject(worldClock, 0);
		Registry registry = LocateRegistry.createRegistry(8888);
		// ???export????????????????????????????????????
		registry.bind("world-clock", remote);
		for(;;) {
			Thread.sleep(5000);
			System.out.println("waiting for remote call");
		}
	}

	public static void rmiClient() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", 8888);
		Remote remote = registry.lookup("world-clock");
		LocalDateTime localDateTime = ((WorldClock) remote).getLocalDateTime();
		System.out.println(localDateTime);
	}

	public static void sendJavaMail() throws MessagingException, IOException {
		String smtp = "smtp.qq.com";
		String mailAccount = "532851150@qq.com";
		String password = "sk8761811";

		Properties props = new Properties();
		props.put("mail.smtp.host", smtp); // SMTP?????????
		props.put("mail.smtp.port", "587"); // ???????????????
		props.put("mail.smtp.auth", "true"); // ????????????????????????
		props.put("mail.smtp.starttls.enable", "true"); // ??????TLS??????properties.setProperty("smtp.s")

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailAccount, password);
			}
		});
		session.setDebug(true);

		// ????????????
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("532851150@qq.com"));
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress("jacob.song@outlook.com")); // TO: xxx
		message.setSubject("test");

		// ?????????????????????
		message.setText("xxx", "UTF-8");
//		message.setText("xxx", "UTF-8", "html");// ?????????html????????????<h1>Hello</h1><p>Hi, xxx</p>

		// ????????????????????????
		Multipart multipart = new MimeMultipart();
		// ????????????
		BodyPart textPart = new MimeBodyPart();
		textPart.setContent("hello", "text/html;charset=utf-8"); // ????????????????????????text/plain;charset=utf-8
		// <img src="http://example.com/test.jpg"> ??????????????????????????????HTML???????????????????????????
		// ????????????image??????
		// textPart.setContent("<h1>Hello</h1><p><img src=\"cid:img01\"></p>", "text/html;charset=utf-8");
		multipart.addBodyPart(textPart);
		// ????????????
		BodyPart imagePart = new MimeBodyPart();
		imagePart.setFileName("xxx"); // ?????????????????????????????????????????????????????????
		// ????????????????????????????????????
		imagePart.setDataHandler(
				new DataHandler(
						new ByteArrayDataSource(new FileInputStream("xxx"), "application/octet-stream")));
		// ?????????multipart???
		// ????????????HTML????????????
		// ?????????????????????MIME TYPE
		imagePart.setDataHandler(
				new DataHandler(
						new ByteArrayDataSource(new FileInputStream("xxx"), "image/jepg")));
		// ??????????????????textPart?????????HTML??????
		imagePart.setHeader("Content-ID", "<img01>");
		multipart.addBodyPart(imagePart);

		Transport.send(message);
	}

	public static  void receiveJavaEmail() throws MessagingException, IOException {
		String host = "outlook.office365.com";
		String port = "995";
		String username = "jacob.song@outlook.com";
		String password = "sk8761811";

		Properties props = new Properties();
		props.setProperty("mail.store.protocol", "pop3"); // ????????????
		props.setProperty("mail.pop3.host", host);// POP3?????????
		props.setProperty("mail.pop3.port", port); // ?????????
		// ??????SSL:
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.port", port);

		URLName urlName = new URLName("pop3", host, Integer.parseInt(port), "", username, password);
		Session session = Session.getInstance(props, null);
//		session.setDebug(true);
		// store?????????????????????????????????
		Store store = new POP3SSLStore(session, urlName);
		store.connect();

		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_WRITE);
		// INBOX status: 1 All 1 Unread 0 Delete 0 New
		System.out.println("INBOX status: "
				+ inbox.getMessageCount() + " All "
				+ inbox.getUnreadMessageCount() + " Unread "
				+ inbox.getDeletedMessageCount() + " Delete "
				+ inbox.getNewMessageCount() + " New");

		javax.mail.Message[] messages = inbox.getMessages();
		for(javax.mail.Message message : messages) {
			printMessage((MimeMessage) message);
		}

		inbox.close(); // ??????true??????????????????????????????????????????
		store.close();
	}

	public static void printMessage(MimeMessage message) throws MessagingException, IOException {
		// subject ????????? Microsoft ??????????????????
		System.out.println("subject " + MimeUtility.decodeText(message.getSubject()));
		Address[] from = message.getFrom();

		// ???????????????
		// Microsoft ????????????
		System.out.println(((InternetAddress)from[0]).getPersonal());
		// account-security-noreply@accountprotection.microsoft.com
		System.out.println(((InternetAddress)from[0]).getAddress());

		// ?????????????????? MimeMessage ??????Part??????
		getMailBody(message);
	}

	// ???????????????BodyPart
	public static void getMailBody(Part message) throws MessagingException, IOException {
		System.out.println(message.getContentType());
		if(message.isMimeType("text/*")) {
			System.out.println(message.getContent().toString());
		} else if(message.isMimeType("multipart/*")) {
			Multipart multipart = (Multipart) message.getContent();
			System.out.println(multipart.getCount());
			for(int i=0;i<multipart.getCount();i++) {
				BodyPart bodyPart = multipart.getBodyPart(i);
				getMailBody(bodyPart);
			}
		}
	}

	// String?????????????????????delim???????????????returnDelims???delim????????????nextToken??????
	public static void stringTokenizerTest() {
		StringTokenizer st = new StringTokenizer("?????????\tMicrosoft\t??????????????????","\t\n\r", false);
		// hasMoreElements ???????????? hasMoreTokens ?????????????????????Enumeration??????????????????
		while(st.hasMoreElements()) {
			System.out.println(st.nextToken() + ",");
		}
	}

	public static void UDPClient() throws IOException {
		DatagramSocket ds = new DatagramSocket();
		ds.setSoTimeout(1000);
		ds.connect(new InetSocketAddress("localhost", 6666));

		byte[] hello = "hello".getBytes();
		DatagramPacket dps = new DatagramPacket(hello, hello.length);
		ds.send(dps);

		byte[] buffer = new byte[1024];
		DatagramPacket dpr = new DatagramPacket(buffer, buffer.length);
		ds.receive(dpr);
		System.out.println(new String(dpr.getData(), dpr.getOffset(), dpr.getLength(), Charset.forName("utf-8")));

		ds.disconnect();
	}

	public static void UDPServer() throws IOException {
		DatagramSocket ds = new DatagramSocket(6666);

		for(;;) {
			byte[] buffer = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
			ds.receive(dp);
			System.out.println(new String(dp.getData(), dp.getOffset(), dp.getLength(), Charset.forName("utf-8")));

			byte[] ack = "ACK".getBytes();
			dp.setData(ack);
			ds.send(dp);
		}
	}

	/*
     * Hash?????????Digest???????????????????????????????????????????????????????????????????????????????????????????????????
     * ?????????????????????????????????????????????
     * ????????????????????????????????????????????????
     * Java??? hashCode() ????????????4??????int??????
     * ????????????????????????????????????????????????????????????
     * ?????????
     * 1. ????????????????????????????????????????????????????????????MD5????????????????????????????????????
     * 2. ???????????????????????????????????????Mysql???????????????????????????????????????????????????????????????????????????MD5??????????????? ??????
     * 3.
	 */
	public static void messageDigest() {
		try {
			// ?????????????????????
			// MD5 128bits 16bytes
			// SHA-1?????????????????????160bits 20bytes
			// SHA-256 256bits 32bytes
			// SHA-512 512bits 64bytes
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update("scy_20170528".getBytes());
			// ?????????salt??????????????????????????????
			md.update("H1r0a".getBytes());
			byte[] digest = md.digest();
			// ??????16???????????????
			System.out.println(new BigInteger(1, digest).toString(16));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	/* ?????????????????? */
	public static void myTemplateEngine() {
		String s = "Hello, ${name}! You are learning ${lang}!";
		Map<String, String> model = new HashMap<>();
		model.put("name", "songkun");
		model.put("lang", "java");
		Pattern pattern = Pattern.compile("\\$\\{(\\w*)\\}");
		Matcher matcher = pattern.matcher(s);
		String result = s;
		while(matcher.find()) {
			result = result.replace(s.substring(matcher.start(), matcher.end()), model.get(matcher.group(1)));
		}
		System.out.println(result);
	}

	public static void regexp2() {
		// split string
		"a b c".split("\\s"); // { "a", "b", "c" }
		"a b  c".split("\\s"); // { "a", "b", "", "c" }
		"a, b ;; c".split("[\\,\\;\\s]+"); // { "a", "b", "c" }

		// search string
		String s1 = "the quick brown fox jumps over the lazy dog.";
		Pattern p = Pattern.compile("\\wo\\w");
		Matcher m = p.matcher(s1);
		while (m.find()) {
			String sub = s1.substring(m.start(), m.end());
		}

		// replace string
		String s2 = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
		String r1 = s2.replaceAll("\\s+", " ");

		// reverse
		String s3 = "the quick brown fox jumps over the lazy dog.";
		String r2 = s3.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
	}

	public static void regexp() {
		String time = "23:01:59";
		Pattern pattern = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})");
		Matcher matcher = pattern.matcher(time);
		if(matcher.matches()) {
			String origin = matcher.group(0); // 23:01:59
			String hour = matcher.group(1); // 23
			int h = Integer.parseInt(hour);
			if(h < 0 || h > 24) {
				throw new IllegalArgumentException("hour illegal");
			}
			String minutes = matcher.group(2); // 01
			int m = Integer.parseInt(minutes);
			if(h < 0 || h > 60) {
				throw new IllegalArgumentException("minute illegal");
			}
			String seconds = matcher.group(3); // 59
			int s = Integer.parseInt(seconds);
			if(h < 0 || h > 60) {
				throw new IllegalArgumentException("second illegal");
			}
			LocalTime lt = LocalTime.of(h, m, s);
			System.out.println(lt);
		}
	}

	static class StringUtilss {
		public static String capitalize(String input) {
			return input.substring(0, 1).toUpperCase().concat(input.substring(1).toLowerCase()).toString().trim();
		}
	}

	static class Factorial {
		public static long fact(long n) {
			if (n < 0) {
				throw new IllegalArgumentException("argument is not negative");
			} else if(n > 20) {
				throw new ArithmeticException("over flow");
			}
			long r = 1;
			for (long i = 1; i <= n; i++) {
				r = r * i;
			}
			return r;
		}
	}

	public static void zonedDateTime() {
		// ZonedDataTime???LocalDateTime???????????????ZoneId?????????TimeZone?????????????????????
		ZonedDateTime zdt1 = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
		ZonedDateTime zdt2 = LocalDateTime.now().atZone(ZoneId.of("America/New_York"));

		// ???????????? ??????????????????????????????
		ZonedDateTime zdt4 = zdt1.withZoneSameInstant(ZoneId.of("America/New_York"));

		// ??????????????????
		zdt4.toLocalDateTime();
	}

	public static void testArriveTime() {
		LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 9, 15, 13, 0, 0);
		int hours = 13;
		int minutes = 20;
		LocalDateTime arriveNY = departureAtBeijing.plusHours(hours).plusMinutes(minutes);
		ZonedDateTime zdtBj = ZonedDateTime.of(arriveNY, ZoneId.of("Asia/Shanghai"));
		ZonedDateTime zdtNy = zdtBj.withZoneSameInstant(ZoneId.of("America/New_York"));
		System.out.println(zdtNy.toLocalDateTime());
	}

	public static void extensionFileInputStreamTest() {
		FileInputStream in = null;
		CountTimingFilterFileInputStream ci = null;
		try {
			in = new FileInputStream("./pom.xml");
			ci = new CountTimingFilterFileInputStream(in);
			while (ci.read() != -1) {
				System.out.println("reading...");
			}
			System.out.println(ci.getResult() + "ms");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
	}

	static class CountTimingFilterFileInputStream extends FilterInputStream {
		private long start;
		private long end;
		private long result;
		private boolean flag = true;

		protected CountTimingFilterFileInputStream(InputStream in) {
			super(in);
		}

		@Override
		public int read() throws IOException {
			if(flag) {
				start = System.currentTimeMillis();
				flag = false;
			}
			int data = super.read();
			if(data == -1) {
				end = System.currentTimeMillis();
			}
			return data;
		}

		public long getResult() {
			return end - start;
		}
	}

	public static void copyFileTest() {
		File file = new File("./pom.xml");
		File copy = new File("./pom_bak.xml");
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(file);
			outputStream = new FileOutputStream(copy);
			int buf = 0;
			while((buf = inputStream.read()) != -1) {
				outputStream.write(buf);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void MockFileTest() {
		byte[] data = { 72, 101, 108, 108, 111, 33 };
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		StringBuilder sb = new StringBuilder();
		try {
			int buf = 0;
			while((buf = in.read()) != -1) {
				sb.append((char)buf);
			}
			System.out.println(sb.toString().trim());
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static List<File> listFiles(File file, FileFilter filter, List<File> list) {
		for (File subFile : file.listFiles(filter)) {
			if(subFile.isDirectory()) {
				listFiles(subFile, filter, list);
			} else {
				System.out.println(subFile);
				list.add(subFile);
			}
		}
		return list;
	}

	public static void unmodifiableCollection() {
		List<String> list = new LinkedList<>();
		list.add("songkun");
		list.add("chenhuihui");
		list.add("songchenyan");
		System.out.println(list);
		List<String> newList = Collections.unmodifiableList(new LinkedList<>(list));
		System.out.println(newList);
		list.add("jiangyanping");
		System.out.println(newList);
		newList.add("songjunhao");
	}

	public static void calculatorExpression() {
		String exp = "1 + 2 * (9 - 5)";
		SuffixExpression se = compile(exp);
		int result = se.execute();
		System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) ? "???" : "???"));
	}

	static SuffixExpression compile(String exp) {
		Deque<String> numlist = new LinkedList<>();
		Deque<String> explist = new LinkedList<>();
		Pattern pattern = Pattern.compile("\\(?\\d\\)?");
		for(String s : exp.split(" ")) {
			if(pattern.matcher(s).matches()) {
				numlist.addFirst(s.replaceAll("\\(?\\)?", ""));
			} else {
				explist.addFirst(s);
			}
		}
		return new SuffixExpression(numlist, explist);
	}

	static class SuffixExpression {
		private final Deque<String> numlist;
		private final Deque<String> explist;
		public SuffixExpression(Deque<String> numlist, Deque<String> explist) {
			this.numlist = numlist;
			this.explist = explist;
		}
		int execute() {
			System.out.println(numlist.toString());
			System.out.println(explist.toString());
			int result = 0;
			while (numlist.size() != 0 && explist.size() != 0) {
				int one = Integer.parseInt(numlist.pollFirst());
				int two = Integer.parseInt(numlist.pollFirst());
				String exp = explist.pollFirst();
				switch(exp) {
					case "+":
						result = one + two;
						break;
					case "-":
						result = Math.abs(one - two);
						break;
					case "*":
						result = one * two;
						break;
						default:
							break;
				}
				numlist.addFirst(String.valueOf(result));
			}
			return Integer.parseInt(numlist.pollFirst());
		}
	}

	public static void toHex() {
		int i = 12500;
		StringBuilder result = new StringBuilder();
		Deque<Character> deque = new LinkedList<>();
		while(i != 0) {
			deque.addFirst(Character.forDigit(i % 16, 16));
			i = i / 16;
		}
		deque.stream().forEach(new Consumer<Character>() {
			@Override
			public void accept(Character character) {
				result.append(character);
			}
		});
		System.out.println(result.toString().toUpperCase().trim());
	}

	public static void collectionQueueTest() {
		List<String> list = new LinkedList<>();
		Queue<String> queue = new LinkedList<>();
	}

	public static void dupMessage() {
		List<Message> received = Arrays.asList(
				new Message(1, "Hello!"),
				new Message(2, "??????????????????"),
				new Message(2, "??????????????????"),
				new Message(3, "???????????????"),
				new Message(3, "???????????????"),
				new Message(4, "Bye")
		);
		List<Message> displayMessages = removeDupMessage(received);
		for (Message message : displayMessages) {
			System.out.println(message.text);
		}
	}

	public static List<Message> removeDupMessage(List<Message> received) {
		SortedSet<Message> set = new TreeSet<>(new Comparator<Message>() {
			@Override
			public int compare(Message o1, Message o2) {
				if(o1.equals(o2)) {
					return 0;
				}
				return o1.sequence > o2.sequence ? 1 : -1;
			}
		});
		set.addAll(received);
		return new ArrayList<>(set);
	}

	static class Message {
		public final int sequence;
		public final String text;
		public Message(int sequence, String text) {
			this.sequence = sequence;
			this.text = text;
		}

		@Override
		public boolean equals(Object obj) {
			if(super.equals(obj)) return false;
			if(obj instanceof Message) {
				if(((Message) obj).text.equals(this.text) && ((Message) obj).sequence == this.sequence) {
					return true;
				}
			}
			return false;
		}

		@Override
		public int hashCode() {
			int h = 0;
			return h*31 + sequence
					+ h*31 + text.hashCode();
		}
	}

	public static void collectionTreeMap() {
		SortedMap<Student, Integer> treeMap = new TreeMap<>();
		treeMap.put(new Student("songkun", 91), 1);
		treeMap.put(new Student("songchenyan", 82), 1);
		treeMap.put(new Student("chenhuihui", 93), 1);
		for(Map.Entry<Student, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}

	static class Student implements Comparable<Student> {
		private String name;
		private Integer score;

		public Student(String name, Integer score) {
			this.name = name;
			this.score = score;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder("Student{");
			sb.append("name='").append(name).append('\'');
			sb.append(", score=").append(score);
			sb.append('}');
			return sb.toString();
		}

		@Override
		public int compareTo(Student o) {
			if(this.score == o.score) {
				return 0;
			}
			return this.score > o.score ? 1 : -1;
		}
	}

	public static void collectionMap1() {
		Map<String, Person> map = new HashMap<>();
		map.put(null, null);
		System.out.println(map.get(null));
		List<Person> list = new ArrayList<>();
		list.add(new Person("songkun", 34));
		Persons persons = new Persons(list);
		Person person1 = persons.getPeopleByName("songkun1");
		Person person2 = persons.getPeopleByName("songkun");
		System.out.println(person1 == person2 ? person1.getName() + " " + person1.getAge() : "error");
	}

	static class Persons {
		private final List<Person> people;
		private final Map<String, Person> cache;

		public Persons(List<Person> list) {
			people = new ArrayList<>(list);
			cache = new HashMap<>(128);
		}

		public Person getPeopleByName(String name) {
			// if name == null return null; throw IllegalArgumentsException
			Person person = null;
			if((person = cache.get(name)) != null) {
				return person;
			}
			for(Person p : people) {
				if(p.getName().equals(name)) {
					person = p;
					cache.put(name, person);
					break;
				}
			}
			return person;
		}

	}

	public static void collectionListTest2() {
		List<Person> list = new ArrayList<>(8);
		list.add(new Person("songkun", 34));
		System.out.println(list.contains(new Person("songchenyan", 34)));
		list.add(0, null);
		System.out.println(list.get(1));
	}


	public static void collectionListTest1() {
		// ?????????start???end????????????
		final int start = 10;
		final int end = 20;
		List<Integer> list = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		// ????????????List??????????????????:
		int removed = list.remove((int) (Math.random() * list.size()));
		int found = findMissingNumberShuffle2(start, end, list);
		System.out.println(removed == found ? "found " + removed + " " + found : "not found");
	}

	/* O(n) */
	public static int findMissingNumberShuffle2(int start, int end, List<Integer> list) {
		int sum = (start + end) * (end - start + 1) / 2;
		System.out.println(sum);
		int listSum = 0;
		for(Integer item : list) {
			listSum += item;
		}
		return sum - listSum;
	}

	/* O(n2) */
	public static int findMissingNumberShuffle(int start, int end, List<Integer> list) {
		for(int i=start;i<=end;i++) {
			if(!list.contains(i)) {
				return i;
			}
		}
		return 0;
	}

	public static int findMissingNumber(int start, int end, List<Integer> list) {
		if(!list.contains(end)) {
			return end;
		}
		Iterator<Integer> iterator = list.iterator();
		int index = start;
		while(iterator.hasNext() && index < end) {
			int found = iterator.next();
			if(found != index) {
				return found - 1;
			}
			index++;
		}
		return 0;
	}

	public static void reflectTest() {
		Class person = Person.class;
		Constructor[] constructors = person.getConstructors();
		for(Constructor constructor : constructors) {
			System.out.println(constructor.getName());
		}

	}


	public static void JDKLogTest() {
		Logger logger = Logger.getLogger(DemoApplication.class.getName());
		logger.info("Start process...");
		try {
			"".getBytes("GBK"); // ??????b
		} catch (UnsupportedEncodingException e) {
			// TODO: ??????logger.severe()????????????
			logger.severe("unsupoorted encoding");
		}
		logger.info("Process end.");

	}

	public static void commonsLog() {
		Log log = LogFactory.getLog(DemoApplication.class);
		log.info("commons log hi");
	}

	public static void slf4jLog() {
		org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DemoApplication.class);
		logger.info("slf4j hi");
	}

	public static void assertTest() {
		double d = Math.abs(-124.45);
		assert d < 0;
		System.out.println(d);
	}

	static class ExceptionSurpress {
		private Exception origin = null;

		public int process1() {
			int result = 0;
			try {
				result = 1 / 0;
				return result;
			} catch (ArithmeticException e) {
				System.out.println("catched");
				origin = e;
			} finally {
				System.out.println("finally");
				result = 2;
				Exception e = new IllegalArgumentException();
				if(origin != null) {
					e.addSuppressed(origin);
				}
				try {
					throw e;
				}catch (Exception h) {
					h.printStackTrace();
				}
			}
			return -1;
		}

		public void process2() {
			try {
				process3();
			} catch (NullPointerException e) {
				throw new IllegalArgumentException(e);
			}
		}

		public void process3() {
			throw new NullPointerException();
		}


	}

	static public class Person {
		private String name;
		private int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public boolean equals(Object obj) {
			if(this == obj) {
				return true;
			}
			if(obj instanceof Person) {
				Person p = (Person) obj;
				if(p.name.equals(this.name) && p.age == this.age) {
					return true;
				}
			}
			return false;
		}
	}

	static String buildSelectSql(String table, String[] fields) {
		StringJoiner sj = new StringJoiner(", ", "SELECT ", " FROM " + table);
		for(String field : fields) {
			sj.add(field);
		}
		return sj.toString();
	}

	static String buildInsertSql(String table, String[] fields) {
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO ")
				.append(table)
				.append("(")
				.append(fields[0])
				.append(",")
				.append(fields[1])
				.append(",")
				.append(fields[2])
				.append(") ")
				.append("VALUE(")
				.append("?,")
				.append("?,")
				.append("?")
				.append(");");
		return builder.toString().trim();
	}

	static void sort(int[] ns) {
		int[] nst = ns;
		int sentinel = 0;
		int max = 0;
		for(int i=0;i<nst.length;i++) {
			for(int j=i;j<nst.length;j++) {
				if(nst[j] > nst[max]) {
					max = j;
				}
			}
			int temp = nst[sentinel];
			nst[sentinel] = nst[max];
			nst[max] = temp;
			sentinel++;
			max = i + 1;
		}
	}

	public interface Income {
		double getTex();
	}

	static public abstract class AbstractIncome implements Income {
		protected double income;
		protected AbstractIncome(double income) {
			this.income = income;
		}

		@Override
		public double getTex() {
			System.out.println("common before");
			double tex = doGetTex();
			System.out.println("common after");
			return tex;
		}

		public abstract double doGetTex();
	}

	static public class IncomeAndBookcomeTex extends AbstractIncome {
		private static int count;
		public IncomeAndBookcomeTex(double income, double bookcome) {
			super(income + bookcome);
			count++;
		}
		@Override
		public double doGetTex() {
			if(income < 5000) {
				return 0;
			}
			return income * 0.3;
		}
	}

}
