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
8. [Example08.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example08.java):  It shows how to apply the t-closeness criterion. 
9. [Example09.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example09.java):  It shows how to apply the d-presence criterion.
10. [Example10.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example10.java):  It shows how to use simple data subsets 
11. [Example11.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example11.java):  It shows how to use data selector 
12. [Example12.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example12.java):  It shows how to use complex data selector 
13. [Example13.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example13.java):  It shows how to use multiple sensitive attributes and different privacy models.
14. [Example14.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example14.java):  It shows how to use loss metrics 
15. [Not found!!!]()
16. [Example16.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example16.java):  It shows how to get some statistics aboutthe data e.g. frequencies
17. [Example17.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example17.java):  It shows how to use data types 
18. [Example18.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example18.java):  It shows how to use hierarchy builders.
19. [Example19.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example19.java):  It shows how to use lattice to create different representation of the results.
20. [Example20.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example20.java):  It shows how to use aggregate functions.

21. [Example21.java](https://github.com/iaBIH/arx_examples/blob/master/src/arxExamples/Example21.java):  It shows how to import data from different sources.

