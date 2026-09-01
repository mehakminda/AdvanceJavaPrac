package com.learning.telusko.question1;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public record OrderSummaryRequest (
        @NotEmpty(message = "OrderId's must not be empty")
        @Size(max= 1000, message ="A maximum of 1000 order Id's is allowed")
        List<Long> orderIDs
){
}

/**
 *
 * Sure. Both @NotEmpty and @Size are Bean Validation annotations.
 * In the previous Spring Boot example, they validate the incoming orderIds
 * before your controller method processes the request.
 *
 *
 * One important point: @Valid
 *
 * These annotations don't automatically run just because you put them on the DTO.
 *
 * That's why the controller had:
 * @PostMapping("/summary")
 * public ResponseEntity<OrderSummaryResponse> getOrderSummary(
 *         @Valid @RequestBody OrderSummaryRequest request) {
 *
 * @Valid tells Spring:
 *
 * "Before calling this method, validate the OrderSummaryRequest using its Bean Validation annotations."
 * Without @Valid, your @NotEmpty and @Size constraints generally won't be triggered for this request body.
 *
 *
 *
 * One other subtlety: @NotEmpty checks that the list itself isn't empty;
 * it does not reject null elements inside the list. If you want [101, null, 103] to be invalid,
 * you can use:
 * @NotEmpty
 * List<@ NotNull Long> orderIds
 *
 *
 * can we use @valid for pathparam?
 * Yes but
 * @Valid is mainly used to trigger validation of an object and its nested fields.
 * For a simple @PathVariable, you normally use constraint annotations directly,
 * such as @Min, @Positive, @Pattern, etc.
 *
 * You would also put @Validated on the controller:
 *
 * @RestController
 * @Validated
 * @RequestMapping("/orders")
 * public class OrderController {
 *
 *     @GetMapping("/{orderId}")
 *     public Order getOrder(
 *             @PathVariable
 *             @Positive(message = "Order ID must be positive")
 *             Long orderId) {
 *         // ...
 *     }
 * }

 *
 * @Validated → enables method-parameter validation
 * @Valid  →  "Validate this object's fields"
 * @Positive / @NotNull / @Size / @Pattern →   "Apply this specific validation rule"
 *
 *
 * is necessary to put @validated on controller?
 *Yes, if you want Spring to perform method-level validation on @PathVariable or @RequestParam
 * constraints, you generally need to enable method validation with @Validated
 * (depending on your Spring Boot/Spring Framework version and configuration).
 *
 * There are two different validation situations:
 * 1 Request Body: @Valid (@Valid triggers validation of the request body.)
 * 2. Path/query Params: @Positive, Spring needs method validation enabled so that @Positive is actually checked.
 *  therefor @Validator is used
 *
 *  @Valid is mainly used to trigger validation of an object and its nested fields.
 *  @Valid doesn't mean "make sure this value is valid."
 *  It tells the validation framework to cascade validation into the object's fields.
 *
 *
 */