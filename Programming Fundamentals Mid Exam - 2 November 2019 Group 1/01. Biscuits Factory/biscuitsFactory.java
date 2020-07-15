1.	Iterating over Map.entrySet() using For-Each loop
       // using keySet() for iteration over keys 
        for (String name : gfg.keySet())  
            System.out.println("key: " + name); 
          
        // using values() for iteration over keys 
        for (String url : gfg.values())  
            System.out.println("value: " + url); 
			
2.	Iterating over keys or values using keySet() and values() methods
        // using iterators 
        Iterator<Map.Entry<String, String>> itr = gfg.entrySet().iterator(); 
          
        while(itr.hasNext()) 
        { 
             Map.Entry<String, String> entry = itr.next(); 
             System.out.println("Key = " + entry.getKey() +  
                                 ", Value = " + entry.getValue()); 
        } 
3.	Iterating using iterators over Map.Entry<K, V>
        // using iterators 
        Iterator<Map.Entry<String, String>> itr = gfg.entrySet().iterator(); 
          
        while(itr.hasNext()) 
        { 
             Map.Entry<String, String> entry = itr.next(); 
             System.out.println("Key = " + entry.getKey() +  
                                 ", Value = " + entry.getValue()); 
        } 
4.	Using forEach(action) method 
        gfg.forEach((k,v) -> System.out.println("Key" + k + "Value" + v));
		
5.	Iterating over keys and searching for values (inefficient)
        for (String name : gfg.keySet())  
        { 
            // search  for value 
            String url = gfg.get(name); 
            System.out.println("Key = " + name + ", Value = " + url); 
        } 