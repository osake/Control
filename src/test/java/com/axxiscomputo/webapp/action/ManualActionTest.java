package com.axxiscomputo.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import com.axxiscomputo.service.GenericManager;
import com.axxiscomputo.model.Manual;
import com.axxiscomputo.webapp.action.BaseActionTestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ManualActionTest extends BaseActionTestCase {
    private ManualAction action;

    @Before
    public void onSetUp() {
        super.onSetUp();

        action = new ManualAction();
        GenericManager manualManager = (GenericManager) applicationContext.getBean("manualManager");
        action.setManualManager(manualManager);

        // add a test manual to the database
        Manual manual = new Manual();

        // enter all required fields
        manual.setTitulo("" + Math.random());
        manual.setUbicacion("KqNiOfLuUyLrTfSgIsRdQbYgYvCbLiCeHtPiEaYcAcNzXgSmYiWeBtEjVgZeYmQpBpPsUrOfGbLiVhFd");

        manualManager.save(manual);
    }

    @Test
    public void testGetAllManuals() throws Exception {
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertTrue(action.getManuals().size() >= 1);
    }

    @Test
    public void testSearch() throws Exception {
        // regenerate indexes
        GenericManager<Manual, Long> manualManager = (GenericManager<Manual, Long>) applicationContext.getBean("manualManager");
        manualManager.reindex();

        action.setQ("*");
        assertEquals(action.list(), ActionSupport.SUCCESS);
        assertEquals(4, action.getManuals().size());
    }

    @Test
    public void testEdit() throws Exception {
        log.debug("testing edit...");
        action.setId(-1L);
        assertNull(action.getManual());
        assertEquals("success", action.edit());
        assertNotNull(action.getManual());
        assertFalse(action.hasActionErrors());
    }

    @Test
    public void testSave() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setId(-1L);
        assertEquals("success", action.edit());
        assertNotNull(action.getManual());

        Manual manual = action.getManual();
        // update required fields
        manual.setTitulo("OaYpLpVaCvRrOqHfOdGiYiNyNyNjGuDpCbVdEdCzFjEpGsLxBbYdLlZuDmCdYcDwRrNuRfUpFnRuPgYmPzJaDlZiJwXiSnApFmTo");
        manual.setUbicacion("OpFmRpIePrJrJxNtCdCdSvGuJpDfUaArRuZfBrJoAlUrQxVbWaZmCsFlFnFsWoXwNeWsYaMhVyPqOzKf");

        action.setManual(manual);

        assertEquals("input", action.save());
        assertFalse(action.hasActionErrors());
        assertFalse(action.hasFieldErrors());
        assertNotNull(request.getSession().getAttribute("messages"));
    }

    @Test
    public void testRemove() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        ServletActionContext.setRequest(request);
        action.setDelete("");
        Manual manual = new Manual();
        manual.setId(-2L);
        action.setManual(manual);
        assertEquals("success", action.delete());
        assertNotNull(request.getSession().getAttribute("messages"));
    }
}