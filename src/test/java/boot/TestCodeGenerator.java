package boot;

import top.tangyh.lamp.generator.CodeGenerator;
import top.tangyh.lamp.generator.config.CodeGeneratorConfig;
import top.tangyh.lamp.generator.config.FileCreateConfig;
import top.tangyh.lamp.generator.type.EntityFiledType;
import top.tangyh.lamp.generator.type.EntityType;
import top.tangyh.lamp.generator.type.GenerateType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 生成lamp-boot项目的代码
 *
 * @author zuihou
 * @date 2019/05/25
 */
public class TestCodeGenerator {
    public static void main(String[] args) {
//        CodeGeneratorConfig build = buildMallEntity();
        CodeGeneratorConfig build = buildAlarmEntity();

        //mysql 账号密码
        build.setUsername("root");
        build.setPassword("root");
        // 指定是boot项目
        build.setIsBoot(true);

        String path = "D:\\Documents\\code\\wcf\\lamp-b\\lamp-boot\\lamp-biz";
        System.out.println("输出路径：" + path);
        build.setProjectRootPath(path);
        // 项目前缀
        build.setProjectPrefix("lamp");
        // 指定全部代码的生成策略
        GenerateType generate = GenerateType.OVERRIDE;
//        generate = null;
        // 构造器传入null，下面设置的策略（setGenerate*）才会生效， 构造器传入不为null时，下面设置的策略（setGenerate*）无效，将全部使用构造器传入的策略
        FileCreateConfig fileCreateConfig = new FileCreateConfig(generate);
        fileCreateConfig.setGenerateEntity(GenerateType.OVERRIDE);
        fileCreateConfig.setGenerateEnum(GenerateType.OVERRIDE);
        fileCreateConfig.setGenerateDto(GenerateType.OVERRIDE);
        // 覆盖生成Xml
        fileCreateConfig.setGenerateXml(GenerateType.OVERRIDE);
        // 忽略生成Dao
        fileCreateConfig.setGenerateDao(GenerateType.OVERRIDE);
        fileCreateConfig.setGenerateServiceImpl(GenerateType.OVERRIDE);
        fileCreateConfig.setGenerateService(GenerateType.OVERRIDE);
        fileCreateConfig.setGenerateController(GenerateType.OVERRIDE);
        build.setFileCreateConfig(fileCreateConfig);

        //手动指定枚举类 生成的路径
        Set<EntityFiledType> filedTypes = new HashSet<>();
        filedTypes.addAll(Arrays.asList(
//                EntityFiledType.builder().name("httpMethod").table("c_common_opt_log")
//                        .packagePath("top.tangyh.lamp.common.enums.HttpMethod").gen(GenerateType.IGNORE).build()
        ));
        build.setFiledTypes(filedTypes);

        build.setPackageBase("top.tangyh.lamp." + build.getChildModuleName());

        // 运行
        CodeGenerator.run(build);
    }


    public static CodeGeneratorConfig buildMallEntity() {
        List<String> tables = Arrays.asList(
                "b_product"
        );
        CodeGeneratorConfig build = CodeGeneratorConfig.
                build("mall", "mall", "zuihou", "b_", tables);
        build.setSuperEntity(EntityType.ENTITY);
        build.setChildPackageName("");
        build.setUrl("jdbc:mysql://127.0.0.1:3306/lamp_extend_0000?serverTimezone=CTT&characterEncoding=utf8&useUnicode=true&useSSL=false&autoReconnect=true&zeroDateTimeBehavior=convertToNull");
        return build;
    }
    public static CodeGeneratorConfig buildManEntity() {
        List<String> tables = Arrays.asList(
                "b_order"
        );
        CodeGeneratorConfig build = CodeGeneratorConfig.
                build("mall", "man", "zuihou", "b_", tables);
        build.setSuperEntity(EntityType.ENTITY);
        build.setChildPackageName("");
        build.setUrl("jdbc:mysql://127.0.0.1:3306/lamp_extend_0000?serverTimezone=CTT&characterEncoding=utf8&useUnicode=true&useSSL=false&autoReconnect=true&zeroDateTimeBehavior=convertToNull");

        build.setIsGenEntity(false);
        return build;
    }

    public static CodeGeneratorConfig buildAlarmEntity() {
        List<String> tables = Arrays.asList(
                "a_alarm_definition",
                "a_alarm_info"
        );
        CodeGeneratorConfig build = CodeGeneratorConfig.
                build("alarm", "alarm", "leo", "a_", tables);
        build.setSuperEntity(EntityType.ENTITY);
        build.setChildPackageName("");
        build.setUrl("jdbc:mysql://127.0.0.1:3306/lamp_column?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useUnicode=true&useSSL=false&autoReconnect=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&nullCatalogMeansCurrent=true");

        build.setIsGenEntity(false);
        return build;
    }


    public static CodeGeneratorConfig buildDeviceEntity() {
        List<String> tables = Arrays.asList(
                "a_device_info"
        );
        CodeGeneratorConfig build = CodeGeneratorConfig.
                build("device", "device", "leo", "a_", tables);
        build.setSuperEntity(EntityType.ENTITY);
        build.setChildPackageName("");
        build.setUrl("jdbc:mysql://127.0.0.1:3306/lamp_column?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useUnicode=true&useSSL=false&autoReconnect=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&nullCatalogMeansCurrent=true");

        build.setIsGenEntity(false);
        return build;
    }


    public static CodeGeneratorConfig buildPortraitEntity() {
        List<String> tables = Arrays.asList(
                "a_portrait_info"
        );
        CodeGeneratorConfig build = CodeGeneratorConfig.
                build("portrait", "portrait", "leo", "a_", tables);
        build.setSuperEntity(EntityType.ENTITY);
        build.setChildPackageName("");
        build.setUrl("jdbc:mysql://127.0.0.1:3306/lamp_column?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useUnicode=true&useSSL=false&autoReconnect=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&nullCatalogMeansCurrent=true");

        build.setIsGenEntity(false);
        return build;
    }


    public static CodeGeneratorConfig buildTaskEntity() {
        List<String> tables = Arrays.asList(
                "a_task_definition",
                "a_task_info"
        );
        CodeGeneratorConfig build = CodeGeneratorConfig.
                build("task", "task", "leo", "a_", tables);
        build.setSuperEntity(EntityType.ENTITY);
        build.setChildPackageName("");
        build.setUrl("jdbc:mysql://127.0.0.1:3306/lamp_column?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useUnicode=true&useSSL=false&autoReconnect=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&nullCatalogMeansCurrent=true");

        build.setIsGenEntity(false);
        return build;
    }


    public static CodeGeneratorConfig buildVenueEntity() {
        List<String> tables = Arrays.asList(
                "a_venue_info"
        );
        CodeGeneratorConfig build = CodeGeneratorConfig.
                build("venue", "venue", "leo", "a_", tables);
        build.setSuperEntity(EntityType.ENTITY);
        build.setChildPackageName("");
        build.setUrl("jdbc:mysql://127.0.0.1:3306/lamp_column?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useUnicode=true&useSSL=false&autoReconnect=true&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&nullCatalogMeansCurrent=true");

        build.setIsGenEntity(false);
        return build;
    }


}
