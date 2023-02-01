package sample.coc.project;

import java.util.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SheetDao {
	 @Autowired
	 SqlSessionTemplate sqlSessionTemplate;
	 
	 public int insert(Map<String, Object> map) {
		  return this.sqlSessionTemplate.insert("coc_sheet.insert", map);
		}
	 public Map<String, Object> selectDetail(Map<String, Object> map) {
		    return this.sqlSessionTemplate.selectOne("coc_sheet.select_detail", map);
		}
	 public int update(Map<String, Object> map) {  
		 return this.sqlSessionTemplate.update("coc_sheet.update", map);  
		 }  
}
