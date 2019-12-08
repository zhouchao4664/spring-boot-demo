package demo.compiler;

import javax.tools.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * @Author zhouchao
 * @Date 2019/11/12 11:22
 * @Description 先要引入jdk中的tools.jar
 **/

public class CompilerDemo {
    public static void main(String[] args) throws IOException {
        // 获取 JavaCompiler
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);

        // 指定 Java Source Code 路径 javac -sourcepath
        // 目标类： demo.compiler.CompilerDemo
        Class<?> targetClass = Compiler.class;

        // 目标类的源文件（相对路径）：demo.compiler.CompilerDemo.java
        String sourceFileRelativePath = targetClass.getName().replace(".", "/").concat(".java");

        // 目标类的源文件（Maven 路径）：${user.dir}/src/main/java + 目标类的源文件（相对路径）
        String soureFilePath = System.getProperty("user.dir") + "/java-demo/src/main/java/" + sourceFileRelativePath;
        File sourceFile = new File(soureFilePath);

        // 指定 Java 新生成的 Class 输出目录（并非编译时依赖的 ClassPath） javac -d
        fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Collections.singleton(getClassOutputDirectory()));
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(sourceFile));

        JavaCompiler.CompilationTask compilationTask =
                javaCompiler.getTask(new OutputStreamWriter(System.out), fileManager, null, null, null, compilationUnits);

        // 执行编译
        compilationTask.call();
    }

    public static File getClassOutputDirectory() {
        File currentClassPath = new File(findClassPath());
        File targetDirectory = currentClassPath.getParentFile();
        File classOutputDirectory = new File(targetDirectory, "new-classes");
        // 生成类输出目录
        classOutputDirectory.mkdir();
        return classOutputDirectory;
    }

    public static String findClassPath() {
        String classPath = System.getProperty("java.class.path");
        return Stream.of(classPath.split(File.pathSeparator))
                .map(File::new)
                .filter(File::isDirectory)
                .filter(File::canRead)
                .filter(File::canWrite)
                .map(File::getAbsolutePath)
                .findFirst()
                .orElse(null);
    }
}
