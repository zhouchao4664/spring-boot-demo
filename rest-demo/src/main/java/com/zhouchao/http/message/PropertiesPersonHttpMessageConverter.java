package com.zhouchao.http.message;

import com.zhouchao.domain.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * 2019/12/29
 * zhouchao
 */
public class PropertiesPersonHttpMessageConverter extends AbstractHttpMessageConverter<Person> {

    public PropertiesPersonHttpMessageConverter() {
        super(MediaType.valueOf("application/properties+person"));
        setDefaultCharset(Charset.forName("UTF-8"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Person.class);
    }

    /**
     * 将请求内容中 Properties 内容转化成 Person 对象
     *
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected Person readInternal(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        /**
         * person.id = 1
         * person.name = zhouchao
         */
        InputStream inputStream = inputMessage.getBody();

        Properties properties = new Properties();
        //将请求重点内容转化成Properties
        properties.load(inputStream);

        Person person = new Person();
        person.setId(Integer.valueOf(properties.getProperty("person.id")));
        person.setName(properties.getProperty("person.name"));

        return person;
    }

    @Override
    protected void writeInternal(Person person, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream outputStream = outputMessage.getBody();

        Properties properties = new Properties();

        properties.setProperty("person.id", String.valueOf(person.getId()));
        properties.setProperty("person.name", person.getName());

        properties.store(new OutputStreamWriter(outputStream,getDefaultCharset()),"Written by web server");
    }
}
