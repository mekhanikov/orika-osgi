package ma.glasnost.orika;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.property.RegexPropertyResolver;
import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;

import ma.glasnost.orika.property.PropertyResolverStrategy;
import ma.glasnost.orika.impl.GeneratedMapperBase;

@Component(name = "orca-osgi",
//Bring this service up even if nobody is using it
immediate = true
//Require configuration to be present to enable this service
//Configuration file will be named ${componentName}.cfg in the etc/ directory
//,configurationPolicy = ConfigurationPolicy.require
)
public class Main {
	
	@Activate
	public void activate(Map<String, String> properties) {
		ma.glasnost.orika.impl.GeneratedMapperBase f = null;//new ma.glasnost.orika.impl.GeneratedMapperBase();
		MapperFactory mapperFactory = 
                new DefaultMapperFactory.Builder()
                    .propertyResolverStrategy(
                            new RegexPropertyResolver(
                                    "readThe([\\w]+)Property",
                                    "writeThe([\\w]+)Property",
                                    true, true))
                    .build();
		
		
		BoundMapperFacade<Person,PersonDto> mapper = mapperFactory.getMapperFacade(Person.class, PersonDto.class);
		
		Name name = new Name("fist", "last");
 
        List<Name> knownAliases = new ArrayList<>();
        knownAliases.add(name);
        knownAliases.add(name);
        knownAliases.add(name);
		Person person = new Person(name, new Date(), knownAliases);
		

	
		Thread.currentThread().setContextClassLoader(ma.glasnost.orika.impl.GeneratedMapperBase.class.getClassLoader());
		
		System.out.println("*** Before conversion");
		PersonDto personDto = mapper.map(person);
		System.out.println(personDto);
		System.out.println("*** Done!!!");
		
	}
	public static void main(String[] args) {
		MapperFactory mapperFactory = 
                new DefaultMapperFactory.Builder()
                    .propertyResolverStrategy(
                            new RegexPropertyResolver(
                                    "readThe([\\w]+)Property",
                                    "writeThe([\\w]+)Property",
                                    true, true))
                    .build();
		
		BoundMapperFacade<Person,PersonDto> mapper = mapperFactory.getMapperFacade(Person.class, PersonDto.class);
		
		Name name = new Name("fist", "last");
 
        List<Name> knownAliases = new ArrayList<>();
        knownAliases.add(name);
        knownAliases.add(name);
        knownAliases.add(name);
		Person person = new Person(name, new Date(), knownAliases);
		
		PersonDto personDto = mapper.map(person);
		System.out.println(personDto);
	}
}
