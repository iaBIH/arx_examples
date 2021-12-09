# ARX Developer Tutorials 

This a spearated repository for [ARX](https://github.com/arx-deidentifier/arx), the open source data anonymization software . These examples are developer tutorials to help get into the ARX code.

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
