# Part A — Problems of the naive approach (no factories)

Baseline: `ShipmentService.ship(mode, item, distanceKm)` creates concrete classes with `new`.

| # | Problem | Where to see it |
|---|---------|-----------------|
| 1 | **Client depends on 9 concrete classes.** `ShipmentService` imports every `Road*`, `Air*`, `Sea*` class. Any change in a product constructor breaks the client. | imports of `ShipmentService` |
| 2 | **Long if/else chain.** Transport mode is a raw `String`; a typo is found only at runtime (`Unknown transport mode`). | `ShipmentService.ship` |
| 3 | **Duplicated business flow.** Products share no interface, so one variable cannot hold "any packaging". The whole flow (pack -> cost -> route -> ETA) is copy-pasted per branch. | 3 branches in `ShipmentService.ship` |
| 4 | **Adding a family edits the client.** Rail means a new `else if`, a new copy of the flow and 3 new imports inside `ShipmentService` (violates Open/Closed). | `ShipmentService` |
| 5 | **Families can be mixed.** Nothing stops air packaging + sea tariff; it compiles and runs silently with a meaningless price. | `Main`, section "Problem: nothing prevents mixing families" |

How to run:

    mkdir -p out && javac -d out $(find src -name "*.java") && java -cp out logistics.Main
