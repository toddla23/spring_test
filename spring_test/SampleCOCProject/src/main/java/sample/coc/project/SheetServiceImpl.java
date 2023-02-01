package sample.coc.project;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SheetServiceImpl implements SheetService{
	 @Autowired
	 SheetDao sheetDao;
	 
		@Override
		public String create(Map<String, Object> map) {
		    int affectRowCount = this.sheetDao.insert(map);
		    if (affectRowCount ==  1) {
		        return map.get("user_id").toString();
		    }
		    return null;
		}
		@Override
		public Map<String, Object> detail(Map<String, Object> map){
		    return this.sheetDao.selectDetail(map);
		}
		@Override  
		public boolean edit(Map<String, Object> map) {  
		int affectRowCount = this.sheetDao.update(map);  
		return affectRowCount == 1;  

		}  
}
