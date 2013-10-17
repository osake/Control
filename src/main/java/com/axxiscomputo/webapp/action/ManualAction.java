package com.axxiscomputo.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.axxiscomputo.service.GenericManager;
import com.axxiscomputo.dao.SearchException;
import com.axxiscomputo.model.Manual;
import com.axxiscomputo.webapp.action.BaseAction;

import java.util.List;

public class ManualAction extends BaseAction implements Preparable {
    private GenericManager<Manual, Long> manualManager;
    private List manuals;
    private Manual manual;
    private Long id;
    private String query;

    public void setManualManager(GenericManager<Manual, Long> manualManager) {
        this.manualManager = manualManager;
    }

    public List getManuals() {
        return manuals;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String manualId = getRequest().getParameter("manual.id");
            if (manualId != null && !manualId.equals("")) {
                manual = manualManager.get(new Long(manualId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            manuals = manualManager.search(query, Manual.class);
        } catch (SearchException se) {
            addActionError(se.getMessage());
            manuals = manualManager.getAll();
        }
        return SUCCESS;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Manual getManual() {
        return manual;
    }

    public void setManual(Manual manual) {
        this.manual = manual;
    }

    public String delete() {
        manualManager.remove(manual.getId());
        saveMessage(getText("manual.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (id != null) {
            manual = manualManager.get(id);
        } else {
            manual = new Manual();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            return "cancel";
        }

        if (delete != null) {
            return delete();
        }

        boolean isNew = (manual.getId() == null);

        manualManager.save(manual);

        String key = (isNew) ? "manual.added" : "manual.updated";
        saveMessage(getText(key));

        if (!isNew) {
            return INPUT;
        } else {
            return SUCCESS;
        }
    }
}