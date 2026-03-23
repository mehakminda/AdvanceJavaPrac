latency: latency measures the delay for a single data packet to travel from its source to its destination



throughput:  how much data passes through a network or system in a given time,



bandwidth: 





Latency is the time it takes for data to pass from one point on a network to another. Suppose Server A in New York sends a data packet to Server B in London. 

Server A sends the packet at 04:38:00.000 GMT and Server B receives it at 04:38:00.145 GMT. The amount of latency on this path is the difference between these 

two times: 0.145 seconds or 145 milliseconds.



Latency, bandwidth, and throughput are all interrelated, but they all measure different things. Bandwidth is the maximum amount of data that can pass through

&nbsp;the network at any given time. Throughput is the average amount of data that actually passes through over a given period of time. Throughput is not necessarily 

&nbsp;equivalent to bandwidth, because it is affected by latency and other factors. Latency is a measurement of time, not of how much data is downloaded over time.





fault tolerant:  Fault tolerance is the system ability to continue operating when components fail. Analogy: a multi-engine airplane that keeps flying when one engine fails

&nbsp;(https://www.cloudopsnow.in/fault-tolerance/





resilient: recovering from failure quickly



master-slave: keeping backups by avoiding single point of failure

(Only master can update, slave only reads/serves  eg: payments/database )



verticial scaling:

horizontal scaling: 





Microservices

usecase:



Monolithic:

usecase:



distributed system: backups





partitioning:











quick response time:



robust:



bottleneck:



-------------------------------------------------------------------------------------------------------------------------------------------------------

What is difference between Rate Limiting and Throttling?



Rate Limiting: (user/client level)

&nbsp;Limit how many requests one user/API key/IP can make in a time window

&nbsp;if user crosses the limit, its request is rejected

&nbsp;applied at API gateway/load balancer/auth layer

&nbsp;used to stop bots/scrappers/brute-force attacks



Throttling: (System level)

&nbsp;Control traffic when the system itself is under pressure

&nbsp;System slows down or temporarily blocks requests

&nbsp;Decision is based on CPU, memory, DB load, queue size

&nbsp;applied at service layer/queue/thread pool/DB connections

&nbsp;used to handle traffic spikes, bursty clients, peak hours



-------------------------------------------------------------------------------------------------------------------------------------------------------

API gateway vs load balancing?



--------------------------------------------------------------------------------------------------------------------------------------------------------

what is API gateway?

A company has put an API gateway infront of its microservices. How does it help?



1\. Single entry point

2\. Load Balancing \& Smart Routing

3\. Central Authentication and authorization

4\. Rate Limiting and Traffic control

5\. Caching at Gateway

6\. Request transformation

7\. Central Logging and monitoring



-------------------------------------------------------------------------------------------------------------------------------------------------------

cache, distributed cache system



cache is storing the data near the client and hence reducing server calls



cache can be in db, browser, application (cdn cache).





-------------------------------------------------------------------------------------------------------------------------------------------------------

horizontal scaling vs vertical scaling



-------------------------------------------------------------------------------------------------------------------------------------------------------

horizontal  vs vertical partitioning (Database)



horizontal is like normalization

vertical is sharding. 



lets say we have 100 rows of data, we first few in shard1 and remaining in shard2. We have a separate table for mapping the row with the corresponding shard(using hashing)



-------------------------------------------------------------------------------------------------------------------------------------------------------



WebHooks vs Web sockets





**WebSockets** and **Webhooks** are both used for real-time communication, but they differ fundamentally in architecture, communication flow, and use cases.



Webhooks are **event-driven HTTP callbacks**. A service sends an HTTP POST request to a pre-registered URL when a specific event occurs. They are **stateless, one-way** (server → client), and ideal for **simple notifications** without maintaining a persistent connection. Example: A payment gateway sending a POST request to your server when a transaction is completed.



How they work:



Client registers a **callback URL** with the provider.

When an event occurs, the provider sends an **HTTP POST** with event data.

The receiving server processes the payload.



**Pros:**



Easy to implement.

Lightweight and cost-effective.

No persistent connection needed.



**Cons:**



One-way only.

Slight latency due to HTTP overhead.

Can overwhelm servers if events spike.



WebSockets are a **bidirectional, persistent communication protocol** over a single TCP connection. They allow **full-duplex** communication between client and server, making them ideal for real-time, interactive applications. Example: A chat app where messages are instantly pushed to all connected users.



How they work:



Client initiates a **handshake** over HTTP.

Server upgrades the connection to **WebSocket protocol** (ws:// or wss://).

Both sides can send/receive messages anytime without re-establishing a connection.



Pros:



Real-time, **low-latency** communication.

Two-way messaging.

Efficient for continuous data streams.



**Cons:**



More complex to implement.

Requires persistent connection management.

Potential firewall/proxy issues



**When to use:**



Webhooks → One-way event notifications (e.g., payment confirmations, CI/CD triggers).

WebSockets → Continuous, interactive communication (e.g., gaming, live dashboards, collaborative editing).



-----------------------------------------------------------------------------------------------------------------------------------------



Acid vs Base vs Cap vs Solid principles



------------------------------------------------------------------------------------------------------------------------------------------



Difference between Sharding vs Indexing vs Partioning



--------------------------------------------------------------------------------------------------------------------------------------------

A memory leak occurs when a computer program incorrectly manages memory, failing to release allocated memory that is no longer needed. This causes the application to constantly consume more RAM, leading to degraded performance, system instability, or crashes. 





---------------------------------------------------------------------------------------------------------------------------





