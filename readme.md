# ARX Developer Tutorials 

This is a spearated repository for [ARX](https://github.com/arx-deidentifier/arx) examples. ARX is an open source data anonymization software. These examples can be used as a  developer tutorial to help get into the ARX code and the data anonymization topic.

**Getting started:**

1. Clone or download this repository
2. Open eclipse, create a new java project, then point to the downloaded folder
   - note you need to uncheck default location
3. In eclipse, open src>arxExample>Example01.java and run as a java application
   - you may need to right click on the project then click run as a java application
   - in case classn Example01 not found error, you may need to add arx jar file:
     - right click on arxExamples project> Build path>Configure build path> Libraries
     - click on Classpath then Add External JARs then select arx-3.9-main.jar which can be found in libs folder.  
      
You should get this output:

            - Input data:
                [age, gender, zipcode]
                [34, male, 81667]
                [45, female, 81675]
                [66, male, 81925]
                [70, female, 81931]
                [34, female, 81931]
                [70, male, 81931]
                [45, male, 81931]
              - Time needed: 0.03s
              - Information loss: 0.5874010519681996 / 0.5874010519681996
              - Optimal generalization
                * zipcode: 3/5
                * gender : 0/1
                * age    : 2/2
              - Statistics
             EquivalenceClassStatistics {
             - Average equivalence class size = 3.5
             - Maximal equivalence class size = 4
             - Minimal equivalence class size = 3
             - Number of equivalence classes = 2
             - Number of records = 7
             - Number of suppressed records = 0
             }
              - Transformed data:
                [age, gender, zipcode]
                [*, male, 81***]
                [*, female, 81***]
                [*, male, 81***]
                [*, female, 81***]
                [*, female, 81***]
                [*, male, 81***]
                [*, male, 81***]                  

**List of examples:**

TODO: organize them to different groups e.g. I/O, anonymization models, hierarchy, statistics, metrics, ... etc

1. [Example01.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example01.java), in this example these concepts are exaplained: 
     - creating data and hierarchy manually  

            DefaultData data = Data.create();
            data.add("age", "gender", "zipcode");
            data.add("34", "male", "81667");
            data.add("45", "female", "81675");
            .
            .
            .
            // Define hierarchies
            DefaultHierarchy age = Hierarchy.create();
            age.add("34", "<50", "*");
            age.add("45", "<50", "*");
        
     - Connect hierarchy on the data, apply anoynimisation, print the input data and the results.  
   The output should be similar to the above output.
   
2. [Example02.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example02.java): In this example these concepts are exaplained: 
   - Same as [Example01.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example01.java), it also shows how to read/write data from/to csv files. The output should look like:

                   Reading data from  data/test.csv ....!!!
                - Time needed: 0.02s
                - Information loss: 0.30055597162146275 / 0.30055597162146275
                - Optimal generalization
                  * zipcode: 3/5
                  * gender : 0/1
                  * age    : 2/2
                - Statistics
                EquivalenceClassStatistics {
                - Average equivalence class size = 3.5
                - Maximal equivalence class size = 4
                - Minimal equivalence class size = 3
                - Number of equivalence classes = 2
                - Number of records = 7
                - Number of suppressed records = 0
                }
                - Writing data...
                Result is saved in data/test_result.csv
                Done!

3. [Example03.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example03.java):    - Same as [Example01.java](https://github.com/iaBIH/arx_examples/blob/master/org/deidentifier/arx/examples/Example01.java).

        
            - Time needed: 0.02s
            - Information loss: 0.3333333332999999 / 0.3333333332999999
            - Optimal generalization
              * zipcode: 2/5
            - Statistics
            EquivalenceClassStatistics {
            - Average equivalence class size = 3.5
            - Maximal equivalence class size = 5
            - Minimal equivalence class size = 2
            - Number of equivalence classes = 2
            - Number of records = 7
            - Number of suppressed records = 0
            }
            - Transformed data:
              [age, gender, zipcode]
              [*, male, 816**]
              [*, female, 816**]
              [*, male, 819**]
              [*, female, 819**]
              [*, female, 819**]
              [*, male, 819**]
              [*, male, 819**]
  
4. [Example04.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example04.java):    - Same as [Example01.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example01.java). It also shows how to get information about the data, define hierarchy using AttributeType. The output should look like this: 

            - inHandle.getNumRows()       :7
            - inHandle.getNumColumns()    :3
            - inHandle.getAttributeName(0):age
            - inHandle.getValue(0,0)      :34
            - Time needed: 0.02s
            - Information loss: 0.3333333332999999 / 0.3333333332999999
            - Optimal generalization
              * zipcode: 2/5
            - Statistics
            EquivalenceClassStatistics {
            - Average equivalence class size = 3.5
            - Maximal equivalence class size = 5
            - Minimal equivalence class size = 2
            - Number of equivalence classes = 2
            - Number of records = 7
            - Number of suppressed records = 0
            }
            - Transformed data:
              [age, gender, zipcode]
              [*, male, 819**]
              [*, female, 819**]
              [*, female, 819**]
              [*, male, 819**]
              [*, male, 819**]
              [*, male, 816**]
              [*, female, 816**]

5. [Example05.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example05.java):    - Same as [Example01.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example01.java). It also shows how to use two privacy models at the same time. The output should look like this: 

            - Time needed: 0.02s
            - Information loss: 0.41421356237309515 / 0.41421356237309515
            - Optimal generalization
              * zipcode: 3/5
              * gender : 0/1
            - Statistics
            EquivalenceClassStatistics {
            - Average equivalence class size = 3.5
            - Maximal equivalence class size = 4
            - Minimal equivalence class size = 3
            - Number of equivalence classes = 2
            - Number of records = 7
            - Number of suppressed records = 0
            }
            - Transformed data:
              [age, gender, zipcode]
              [34, male, 81***]
              [45, female, 81***]
              [66, male, 81***]
              [70, female, 81***]
              [34, female, 81***]
              [70, male, 81***]
              [45, male, 81***]
6. [Example06.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example06.java):  Similar to 5 
7. [Example07.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example07.java):  Similar to 5 
8. [Example08.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example08.java):  t-closeness criterion. 
9. [Example09.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example09.java):  d-presence criterion.
10. [Example10.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example10.java): data subsets 
11. [Example11.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example11.java): data selector 
12. [Example12.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example12.java): complex data selector 
13. [Example13.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example13.java): multiple sensitive attributes and different privacy models.
14. [Example14.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example14.java): loss metrics 
15. [Not found!!!]()
16. [Example16.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example16.java): statistics e.g. frequencies
17. [Example17.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example17.java): data types 
18. [Example18.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example18.java): hierarchy builders.
19. [Example19.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example19.java): lattice, creating different representation of the results.
20. [Example20.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example20.java): aggregate functions.
21. [Example21.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example21.java): import data from different sources.
22. [Example22.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example22.java): l-diversity privacy model without protecting sensitive assocations. 
23. [Example23.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example23.java): multiple instances of l-diversity without protecting sensitive associations. 
24. [Example24.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example24.java): directly using empty and functional hierarchies. 
25. [Example25.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example25.java): generalized loss metric with different types of generalization hierarchies.  
26. [Example26.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example26.java): an interval-based hierarchy builder with high precision . 
27. [Example27.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example27.java): data cleansing capabilities 
28. [Example28.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example28.java): data cleansing using the DataSource functionality. 
29. [Example29.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example29.java): risk analysis
30. [Example30.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example30.java): summary statistics 
31. [Example31.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example31.java): microaggregation 
32. [Example32.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example32.java): microaggregation with generalization 
33. [Example33.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example33.java): microaggregation: attribute types and transformation methods should be specified separately. 
34. [Example34.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example34.java): heuristic search algorithm 
35. [Example35.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example35.java): HIPAA identifiers 
36. [Example36.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example36.java): utility-based microaggregation 
37. [Example37.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example37.java): E,D Differential Privacy
38. [Example38.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example38.java): local recoding 
39. [Example39.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example39.java): compare data mining performance  
40. [Example40.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example40.java): compare data mining performanc 
41. [Example41.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example41.java): k-map model 
42. [Example42.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example42.java): k-map and d-presence models combined  
43. [Example43.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example43.java): evaluate combined risk metrics 
44. [Example44.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example44.java): k-map privacy model with a statistical estimator. 
45. [Example45.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example45.java): mixed risk model 
46. [Example46.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example46.java): distribution of risks  
47. [Example47.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example47.java): evaluating distinction and separation of attributes, ref: Motwani et al. "Efficient algorithms for masking and finding quasi-identifiers" Proc. VLDB Conf., 2007. 
48. [Example48.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example48.java): ordered distance t-closeness, ref: Li et al. "t-Closeness: Privacy Beyond k-Anonymity and l-Diversity"
49. [Example49.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example49.java): no-attack, game-theoretic, a monetary cost/benefit analysis using prosecutor risk. 
50. [Example50.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example50.java): no-attack, game-theoretic, a monetary cost/benefit analysis using journalist risk. 
51. [Example51.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example51.java): game-theoretic, a monetary cost/benefit analysis using prosecutor risk. 
52. [Example52.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example52.java): game-theoretic, a monetary cost/benefit analysis using journalist risk.  
53. [Example53.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example53.java): generate pdf reports 
54. [Example54.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example54.java): access quality statistics 
55. [Example55.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example55.java): fast algorithm for local recoding with ARX 
56. [Example56.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example56.java): evaluate risk with wildcard matching 
57. [Example57.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example57.java): analyze risks with wildcards for data transformed with cell suppression 
58. [Example58.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example58.java): consistent handling of suppressed records in input and output 
59. [Example59.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example59.java): handling of suppressed values and records in input data
60. [Example60.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example60.java): processing high-dimensional data
