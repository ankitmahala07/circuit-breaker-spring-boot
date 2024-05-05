# circuit-breaker-spring-boot
This project is a template on how to use circuit breaker pattern in our service using Netflix Hystrix dependency.

# things to know
1. Resilience4j is compatible with Spring boot 3 whereas there are challenges in getting Netflix Hystrix to get it to work with Spring boot 3.
2. Resilience4j can help us make our system fault tolerant by providing us options to configure our circuit breaker to have fallback methods.
3. We can configure directly the endpoints (as shown in the project) or we can make fallback methods for our generic service layer methods as well.
4. We can expose health metrics to check the state and stats of each circuit breaker present in our service through actuator endpoints or we can expose it for prometheus as well.

# list of properties that can be configured for global level or individual circuit breaker
Reference - https://resilience4j.readme.io/docs/circuitbreaker
1. failureRateThreshold - default (50) in %
2. slowCallRateThreshold - default (100) in %
3. slowCallDurationThreshold - default (60000) in ms
4. permittedNumberOfCallsInHalfOpenState - default (10)
5. maxWaitDurationInHalfOpenState - default (0) in ms
6. slidingWindowType - default (COUNT_BASED) or TIME_BASED
7. slidingWindowSize - default (100)
8. minimumNumberOfCalls - default (100)
9. waitDurationInOpenState - default (60000) in ms
10. automaticTransitionFromOpenToHalfOpenEnabled - default (false)
11. recordExceptions - default (empty)
12. ignoreExceptions - default (empty)
13. recordFailurePredicate - default (true)
14. ignoreExceptionPredicate - default (false)
 