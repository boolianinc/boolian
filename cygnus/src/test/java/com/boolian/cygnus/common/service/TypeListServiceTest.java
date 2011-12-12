package com.boolian.cygnus.common.service;

import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.fornax.cartridges.sculptor.framework.test.AbstractDbUnitJpaTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.boolian.cygnus.common.domain.Language;
import com.boolian.cygnus.common.domain.TypeList;
import com.boolian.cygnus.common.domain.TypeListDetail;

/**
 * Spring based transactional test with DbUnit support.
 */
public class TypeListServiceTest extends AbstractDbUnitJpaTests
    implements TypeListServiceTestBase {
	
    @Autowired
    protected TypeListService typeListService;

    @Test
    public void testFindById() throws Exception {
        // TODO Auto-generated method stub
        //fail("testFindById not implemented");
    }

    @Test
    public void testFindAll() throws Exception {
        // TODO Auto-generated method stub
        //fail("testFindAll not implemented");
    }

    @Test
    public void testSave() throws Exception {
        // TODO Auto-generated method stub
        //fail("testSave not implemented");
    	
    	for (int i = 0; i < 100; i++) {
    		
	    	TypeList typeListEntity = getTypeListObject("SaveTest" + i, 100);
	    	
			typeListService.save(typeListEntity);
    	}
		
		List<TypeList> typeList = typeListService.findAll();
		
		Assert.assertEquals(100, typeList.size());
		
//		TypeList typeList2 = typeList.get(0);
//		
//		System.out.println(typeList2);
		
		for (int i = 0; i < typeList.size(); i++) {
			
			TypeList typeList2 = typeList.get(i);
			
//			Iterator<TypeListDetail> iterator = typeList2.getTypeListDetail().iterator();
			
			//Assert.assertEquals(100, typeList2.getTypeListDetail().size());
			
//			while (iterator.hasNext()) {
//				
//				TypeListDetail typeListDetail2 = iterator.next();
//				
//				System.out.println(typeListDetail2);
//				System.out.println(typeListDetail2.getLangId());
//			}			
		}		
    }

    @Test
    public void testDelete() throws Exception {
        // TODO Auto-generated method stub
        //fail("testDelete not implemented");
    }
    
    private TypeList getTypeListObject(String desc, int numOfDetails) {
    	
    	Language languageEntity = new Language(desc, desc);
    	
    	languageEntity.setChar3Code(desc);
        	
    	TypeList typeListEntity = new TypeList(desc);
    	typeListEntity.setDescription(desc);
    	
    	for (int i = 0; i < numOfDetails; i++) {
    		
	    	TypeListDetail typeListDetailElement = new TypeListDetail(desc + Math.random());
	    	typeListDetailElement.setCode(desc + i);
	    	typeListDetailElement.setDescription(desc + i);
	    	typeListDetailElement.setLangId(languageEntity);
	    	
	    	//typeListEntity.addTypeListDetail(typeListDetailElement);
    	}
    	    	
		return typeListEntity;
    }
}
