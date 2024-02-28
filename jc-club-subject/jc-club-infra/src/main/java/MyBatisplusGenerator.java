import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成器
 * @author: litangsong
 * @date: 2024/2/28 14:48
 */
public class MyBatisplusGenerator {


    /**
     * 生产代码的数据源信息
     */
    private static final String GEN_DATA_SOURCE_URL = "jdbc:mysql://localhost:3306/jc-club?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=true&verifyServerCertificate=false";
    private static final String GEN_DATA_SOURCE_USER = "lee";
    private static final String GEN_DATA_SOURCE_PASSWORD = "123456";


    public static void main(String[] args) {
        List<String> tableNameList = new ArrayList();
        //表名
        tableNameList.add("subject_category");
//        tableNameList.add("t_task_detail_settled");
//        tableNameList.add("t_task_user_auth_settled");
        MyBatisplusGenerator.generator(tableNameList);
    }


    /**
     * 代码生成器
     *
     * @param tableNameList 表名
     */
    private static void generator(List<String> tableNameList) {
        AutoGenerator autoGenerator = new AutoGenerator();

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.jingdianjcihi.subject.infra.basic");

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbQuery(new MySqlQuery());
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert());
        dataSourceConfig.setUrl(GEN_DATA_SOURCE_URL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername(GEN_DATA_SOURCE_USER);
        dataSourceConfig.setPassword(GEN_DATA_SOURCE_PASSWORD);

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude(tableNameList.toArray(new String[0]));
        strategyConfig.setCapitalMode(true);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntitySerialVersionUID(true);
        strategyConfig.setEntityBuilderModel(true);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setEntityBooleanColumnRemoveIsPrefix(true);

        TemplateConfig template = new TemplateConfig();
        template.setXml(null);
        template.setController(null);

        //直接生成到类对应的位置
        String outPath = MyBatisplusGenerator.class.getResource("/").getPath();
        String javaOutPath = outPath.substring(0, outPath.lastIndexOf("target")) + "/src/main/java/";
        String xmlOutPath = outPath.substring(0, outPath.lastIndexOf("target")) + "/src/main/resources/mapper/";

        List<FileOutConfig> fileOutConfigList = new ArrayList();
        //调整xml生成目录
        fileOutConfigList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return xmlOutPath + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {

            }
        };
        injectionConfig.setFileOutConfigList(fileOutConfigList);

        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(javaOutPath);
        globalConfig.setOpen(false);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setMapperName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setAuthor("admin");
        globalConfig.setIdType(IdType.ASSIGN_ID);
        globalConfig.setDateType(DateType.TIME_PACK);

        ConfigBuilder configBuilder = new ConfigBuilder(packageConfig, dataSourceConfig, strategyConfig, template, globalConfig);
        autoGenerator.setCfg(injectionConfig);
        autoGenerator.setConfig(configBuilder);
        autoGenerator.execute();
    }

}
