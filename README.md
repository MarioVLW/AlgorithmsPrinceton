# AlgorithmsPrinceton

Social network connectivity. Given a social network containing nn members and a log file containing mm timestamps at which times pairs of members formed friendships, design an algorithm to determine the earliest time at which all members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. The running time of your algorithm should be m \log nmlogn or better and use extra space proportional to nn.

# Solution

Knowing that the members will be connected iff the root of every item is the same. There is a change we can figure this by checking everyone of the items and compare the root of them. Nevetheless, this is very cost model as the execution time will increase as N increases. 

Other strategy will having some counter, so every new connection is stablished the counter will decrease/increase and we must reach N-1 connections to knowing that all the nodes are connected. Take into account that if a redundant connection is requested then this counter will not be increased/decreased. 

## Example:

some examples of redundant connection request are the following:
```java
union(0,1);
union(1,0); //Redundant connection
```

```java
union(0,1);
union(2,0);
union(2,1); //Redundant connection
```

