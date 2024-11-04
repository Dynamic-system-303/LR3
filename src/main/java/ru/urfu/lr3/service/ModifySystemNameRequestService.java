package ru.urfu.lr3.service;

import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.urfu.lr3.model.Request;
import ru.urfu.lr3.util.DateTimeUtil;

import java.util.Date;

@Service
@Primary
public class ModifySystemNameRequestService implements ModifyRequestService {
    @Override
    public void modify(Request request) {

        request.setSource("source 1");
        request.setSystemName("service 1");
        request.setSystemTime(DateTimeUtil.getDateFormat().format(new Date()));

        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });

    }
}
