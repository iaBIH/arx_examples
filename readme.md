# ARX Developer Tutorials 

This is a spearated repository for [ARX](https://github.com/arx-deidentifier/arx), the open source data anonymization software. These examples can be used as a  developer tutorial to help get into the ARX code.

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

1. [Example01.java](https://github.com/iaBIH/arx_examples/blob/master/org/deidentifier/arx/examples/Example01.java): In this example these concepts are exaplained: 
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
2. [Example02.java](https://github.com/iaBIH/arx_examples/blob/master/org/deidentifier/arx/examples/Example02.java): In this example these concepts are exaplained: 
   - Same as [Example01.java](https://github.com/iaBIH/arx_examples/blob/master/org/deidentifier/arx/examples/Example01.java) and add saving the data and the results to csv file.     
