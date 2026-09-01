package com.learning.telusko.question1;

import java.math.BigDecimal;
import java.util.List;


public record OrderSummaryResponse(
        BigDecimal totalAmount,
        BigDecimal minOrderValue,
        BigDecimal maxOrderValue,
        long count
) {}


/* //chatgpt approach was using jdbc template
public record OrderSummaryResponse (int requestCount,
                                    long foundCount,
                                    BigDecimal totalAmount,
                                    BigDecimal minOrderValue,
                                    BigDecimal maxOrderValue,
                                    List<Long> missingOrderIds) {

}*/
