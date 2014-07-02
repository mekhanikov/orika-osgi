package ma.glasnost.orika;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public class Mapper extends ConfigurableMapper {
	protected void configure(MapperFactory factory) {
		factory.classMap(Person.class, PersonDto.class)
		.field("name.first", "firstName")
		.field("name.last", "lastName")
		.field("knownAliases{first}", "aliases{[0]}")
		.field("knownAliases{last}", "aliases{[1]}")
		.byDefault()
		.register();      
	}
}
