/**
 * Copyright [2021] [RAFAEL ALCOCER CALDERA]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rafael.alcocer.caldera.spring.boot.elasticsearch.service;

import java.io.IOException;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ElasticsearchServiceImpl implements ElasticsearchService {

    private final RestHighLevelClient restHighLevelClient;

    @Override
    public String index(String index, String id, String jsonString) {
        IndexRequest indexRequest = new IndexRequest(index);
        indexRequest.id(id);
        indexRequest.source(jsonString, XContentType.JSON);

        try {
            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);

            return indexResponse.getIndex() + ": " + indexResponse.getResult();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public GetResponse get(String index, String id) {
        GetRequest getRequest = new GetRequest(index, id);

        try {
            GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            
            System.out.println("##### getResponse.getId(): " + getResponse.getId());
            System.out.println("##### getResponse.getIndex(): " + getResponse.getIndex());
            System.out.println("##### getResponse.getSourceAsString(): " + getResponse.getSourceAsString());
            System.out.println("##### getResponse.getSource(): " + getResponse.getSource());

            return getResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
