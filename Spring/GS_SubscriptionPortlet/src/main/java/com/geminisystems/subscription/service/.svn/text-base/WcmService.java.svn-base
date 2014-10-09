package com.geminisystems.subscription.service;

import com.geminisystems.subscription.domain.SCategory;
import com.geminisystems.subscription.job.SendUsersMailJob;
import com.ibm.workplace.wcm.api.*;
import com.ibm.workplace.wcm.api.exceptions.*;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: GGobozov
 * Date: 14.11.2011
 * Time: 14:10:07
 * To change this template use File | Settings | File Templates.
 */
public class WcmService {

    private Logger logger = Logger.getLogger(SendUsersMailJob.class);
    private static final String WCM_LIBRARY = "Web Content";
    private Repository repository;
    private Workspace workspace;


    public WcmService() {
        try {
            repository = WCM_API.getRepository();
            workspace = repository.getSystemWorkspace();
            workspace.setCurrentDocumentLibrary(workspace.getDocumentLibrary(WCM_LIBRARY));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Content> getModifiedContent(Date from, Date to) {
        List<Content> contentList = new ArrayList<Content>();

            DocumentIdIterator iter = workspace.findContentModifiedBetween(from, to, Workspace.WORKFLOWSTATUS_PUBLISHED);
            while (iter.hasNext()) {
                try {
                    DocumentId id = iter.nextId();
                    if (id.isOfType(DocumentTypes.Content)) {

                        Content content = (Content) workspace.getById(id);
                        Date publishDate = content.getEffectiveDate();
                        if (publishDate.before(from) || publishDate.after(to))
                            continue;
                        contentList.add(content);
                    }
                } catch (DocumentRetrievalException e) {
                    e.printStackTrace();
                } catch (AuthorizationException e) {
                    e.printStackTrace();
                } catch (PropertyRetrievalException e) {
                    e.printStackTrace();
                }
            }

        return contentList;
    }

    public List<Content> getNewContentByArea(List<Content> allModifiedContent, SCategory category, String path) {
        logger.setLevel(Logger.getRootLogger().getLevel());
        List<Content> newContent = new ArrayList<Content>();
        try {

            DocumentId siteAreaId = getDocIdByPath(workspace, path);
            if (siteAreaId == null) return null;
            SiteArea siteArea = (SiteArea) workspace.getById(siteAreaId);
            DocumentId authoringTemplateId = getDocIdByName(workspace, category.getAtName(), DocumentTypes.AuthoringTemplate);


            String  categoryPath = path.replaceAll("\\s", "+");

            for (Content c : allModifiedContent) {

                String contentPath = workspace.getPathById(c.getId(), false, false);
                // if (siteArea.hasContent(c.getId())) { // if site area has content
                //if (isSiteAreaHasContent(siteArea, c.getId())) { // if site area has content
                if (contentPath.toLowerCase().indexOf(categoryPath.toLowerCase()) != -1) { // if site area has content
                    if (authoringTemplateId != null) {
                        if (c.getAuthoringTemplateID().equals(authoringTemplateId)) { // if authoring template equals
                            logger.debug("found content by path = " + contentPath);
                            newContent.add(c);
                        }
                    } else {
                        logger.debug("found content by path = " + contentPath);
                        newContent.add(c);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return newContent;

    }

    public boolean isSiteAreaHasContent(SiteArea area, DocumentId content) {
        try {
            if (area.hasContent(content)) return true;
            DocumentIdIterator iter = area.getChildren(Workspace.WORKFLOWSTATUS_PUBLISHED);
            if (iter.hasNext()) {
                while (iter.hasNext()) {
                    DocumentId id = iter.nextId();
                    if (id.getType().toString().equals(DocumentTypes.SiteArea.toString())) {
                        SiteArea sa = (SiteArea) workspace.getById(id);
                        if (sa.hasContent(content))
                            return true;
                        else
                            isSiteAreaHasContent(sa, content);
                    }
                }
            }
        } catch (DocumentRetrievalException e) {
            e.printStackTrace();
        } catch (AuthorizationException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Workspace getWorkspace() {
        return workspace;
    }

    public void setWorkspace(Workspace workspace) {
        this.workspace = workspace;
    }

    public DocumentId getDocIdByPath(Workspace workspace, String path) {
        DocumentIdIterator i = workspace.findByPath(path, Workspace.WORKFLOWSTATUS_PUBLISHED);
        if (i.hasNext()) {
            DocumentId id = i.nextId();
            return id;
        }
        return null;
    }

    public DocumentId getDocIdByName(Workspace workspace, String name, DocumentType type) {
        DocumentIdIterator i = workspace.findByName(type, name);
        if (i.hasNext()) {
            DocumentId id = i.nextId();
            return id;
        }
        return null;
    }


}
