package com.enyoi.orders.service;

import com.enyoi.orders.dto.ClientResponseDto;
import com.enyoi.orders.dto.CreateNewOrderCreatingNewClientDto;
import com.enyoi.orders.dto.GenerateNewOrderDto;
import com.enyoi.orders.model.Order;
import com.enyoi.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    public Order createNewOrder(GenerateNewOrderDto dto){
        //GENERO LA URL
        String url = "http://localhost:8081/api/v1/client/" + dto.getClientEmail();

        ResponseEntity<ClientResponseDto> responseEntityDto = restTemplate.exchange(
                url, HttpMethod.GET, null, ClientResponseDto.class);

        if(responseEntityDto.getStatusCode().is2xxSuccessful()){
            ClientResponseDto bodyResponse = responseEntityDto.getBody();
            Order order = new Order();
            order.setClientId(bodyResponse.getId());
             return orderRepository.save(order);
        }

        throw new RuntimeException("ERROR");
    }


    public Order createNewOrderCreatingNewClient(CreateNewOrderCreatingNewClientDto dto){
        String url =  "http://localhost:8081/api/v1/client";


        HttpEntity<CreateNewOrderCreatingNewClientDto> request = new HttpEntity<>(dto);

        
        ResponseEntity<ClientResponseDto> responseEntity = restTemplate.exchange(
                url, HttpMethod.POST, request, ClientResponseDto.class);

        ClientResponseDto bodyResponse = responseEntity.getBody();
        Order order = new Order();
        order.setClientId(bodyResponse.getId());
        return orderRepository.save(order);


    }


}