package sample.coc.project;

import java.util.Map;

public interface SheetService {

	String create(Map<String, Object> map);

	Map<String, Object> detail(Map<String, Object> map);

	boolean edit(Map<String, Object> map);

}
