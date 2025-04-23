package demo.thread;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * @Description: CompletableFuture test
 * @Author : zhouchao
 * @Date : 2025-01-05 21:59
 */
@Slf4j
public class CompletableFutureTest {

    private static Logger LOGGER = LoggerFactory.getLogger(CompletableFutureTest.class);

    private String sout(String pnSoldTo){
        LOGGER.error("enter getInhibitorResp... pnSoldTo: {}", pnSoldTo);
        return null;
    }

    public static void main(String[] args) {
        String list = "[\"20XW003FUS_1213066999\", \"4X20M26268_1213066999\", \"4X40E77329_1213066999\", \"78010719_1213066999\"," +
                " \"82FG0164US_1213066999\", \"GX20P92530_1213066999\", \"GX40S69333_1213066999\", \"GXD0T69864_1213066999\"," +
                " \"GXY0K07131_1213066999\", \"GY40Y57708_1213066999\", \"XXXX007926_1213066999\", \"11RTZ9C8US_1213066999\"," +
                " \"GX30M39606_1213066999\", \"81YT0006US_1213066999\", \"4L67A08366_1213066999\", \"4ZC7A08710_1213066999\"," +
                " \"4ZC7A08739_1213066999\", \"7G17A03537_1213066999\", \"21HDCTO1WW0001_1213066999\", \"5AS7A83094_1213066999\"," +
                " \"GX40Z24050_1213066999\", \"GY50R91293_1213066999\", \"5AS7A83088_1213066999\", \"78024053_1213066999\"," +
                " \"20USCTO1WW000V_1213066999\", \"7S050015WW_1213066999\", \"7X02A0CENA_1213066999\", \"7Y45A04PNA_1213066999\"," +
                " \"4XB0N10301_1213066999\", \"5WS0A23681_1213066999\", \"5WS0T36151_1213066999\", \"5WS0U26639_1213066999\", " +
                "\"21J6S0XW00_1213066999\", \"01CV750_1213066999\", \"7Y71100CNA_1213066999\", \"0A36332_1213066999\"," +
                " \"0A61769_1213066999\", \"0A61770_1213066999\", \"30DHS0B000_1213066999\", \"5WS0V07055_1213066999\"," +
                " \"5WS0V07058_1213066999\", \"5WS0V07063_1213066999\", \"78000163_1213066999\", \"78000198_1213066999\", " +
                "\"78000279_1213066999\", \"30BDCTO1WW000G_1213066999\", \"82KU00YQUS_1213066999\", \"4X90Q84427_1213066999\"," +
                " \"4P57A12649_1213066999\", \"4XB7A10196_1213066999\", \"4XB7A10248_1213066999\", \"5PS7A06895_1213066999\", " +
                "\"5WS0L38186_1213066999\", \"5WS0L38650_1213066999\", \"5WS0Q65670_1213066999\", \"7S06020NWW_1213066999\", " +
                "\"7X06Q0AM00_1213066999\", \"7Y03A08ZNA_1213066999\", \"30DHS00N00_1213066999\", \"45674567_1213066999\", " +
                "\"CBOFP44889_1213066999\"]";

        List<String> listAllDistinct= JsonUtil.jsonToList(list,String.class);
        // 切分ID集合为大小为20的子集
        List<List<String>> productListChunks = chunkList(listAllDistinct, 1000);

        LOGGER.error("productListChunks: {}",JsonUtil.toJson(productListChunks));
        // 使用CompletableFuture进行异步调用和合并结果
        List<CompletableFuture<Void>> futures = productListChunks.stream().map(chunk ->
                        CompletableFuture.runAsync(() -> {
                            chunk.stream().parallel().forEach(pnSoldto -> {
                                String soldTo = pnSoldto.split("_")[1];
                                new CompletableFutureTest().sout(pnSoldto);
                            });
                        })
        ).collect(Collectors.toList());
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allOf.join();
    }

    private static <T> List<List<T>> chunkList(List<T> list, int chunkSize) {
        List<List<T>> chunks = new ArrayList<>();
        for (int i = 0; i < list.size(); i += chunkSize) {
            int end = Math.min(i + chunkSize, list.size());
            chunks.add(list.subList(i, end));
        }
        return chunks;
    }


}
