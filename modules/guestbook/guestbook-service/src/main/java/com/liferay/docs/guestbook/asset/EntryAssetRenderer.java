package com.liferay.docs.guestbook.asset;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.docs.guestbook.model.Entry;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


public class EntryAssetRenderer extends BaseJSPAssetRenderer<Entry> {
    public EntryAssetRenderer(Entry entry) {

        _entry = entry;
    }

    @Override
    public boolean hasViewPermission(PermissionChecker permissionChecker)
            throws PortalException {

        long entryId = _entry.getEntryId();
        return true;
    }

    @Override
    public Entry getAssetObject() {
        return _entry;
    }

    @Override
    public long getGroupId() {
        return _entry.getGroupId();
    }

    @Override
    public long getUserId() {

        return _entry.getUserId();
    }

    @Override
    public String getUserName() {
        return _entry.getUserName();
    }

    @Override
    public String getUuid() {
        return _entry.getUuid();
    }

    @Override
    public String getClassName() {
        return Entry.class.getName();
    }

    @Override
    public long getClassPK() {
        return _entry.getEntryId();
    }

    @Override
    public String getSummary(PortletRequest portletRequest,
                             PortletResponse portletResponse) {
        return "Name: " + _entry.getName() + ". Message: " + _entry.getMessage();
    }

    @Override
    public String getTitle(Locale locale) {
        return _entry.getMessage();
    }

    @Override
    public boolean include(HttpServletRequest request,
                           HttpServletResponse response, String template) throws Exception {
        request.setAttribute("ENTRY", _entry);
        request.setAttribute("HtmlUtil", HtmlUtil.getHtml());
        request.setAttribute("StringUtil", new StringUtil());
        return super.include(request, response, template);
    }

    @Override
    public String getJspPath(HttpServletRequest request, String template) {

        System.out.println("Entry is :"+ template);
        if (template.equals(TEMPLATE_FULL_CONTENT)) {
            request.setAttribute("gb_entry", _entry);

            return "/asset/entry/" + template + ".jsp";
        } else {
            return null;
        }
    }

    @Override
    public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
                                 LiferayPortletResponse liferayPortletResponse) throws Exception {
        PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
                getControlPanelPlid(liferayPortletRequest), "com_liferay_docs_guestbook_portlet_GuestbookPortlet",
                PortletRequest.RENDER_PHASE);
        portletURL.setParameter("mvcPath", "/guestbookwebportlet/edit_entry.jsp");
        portletURL.setParameter("entryId", String.valueOf(_entry.getEntryId()));
        portletURL.setParameter("showback", Boolean.FALSE.toString());

        return portletURL;
    }

    @Override
    public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
                                      LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect)
            throws Exception {
        try {
            long plid = PortalUtil.getPlidFromPortletId(_entry.getGroupId(),
                    "com_liferay_docs_guestbook_portlet_GuestbookPortlet");

            PortletURL portletURL;
            if (plid == LayoutConstants.DEFAULT_PLID) {
                portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
                        "com_liferay_docs_guestbook_portlet_GuestbookPortlet", PortletRequest.RENDER_PHASE);
            } else {
                portletURL = PortletURLFactoryUtil.create(liferayPortletRequest,
                        "com_liferay_docs_guestbook_portlet_GuestbookPortlet", plid, PortletRequest.RENDER_PHASE);
            }

            portletURL.setParameter("mvcPath", "/guestbookwebportlet/view.jsp");
            portletURL.setParameter("entryId", String.valueOf(_entry.getEntryId()));

            String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

            portletURL.setParameter("redirect", currentUrl);

            return portletURL.toString();

        } catch (PortalException e) {

        } catch (SystemException e) {
        }

        return noSuchEntryRedirect;
    }

    @Override
    public String getURLView(LiferayPortletResponse liferayPortletResponse,
                             WindowState windowState) throws Exception {

        return super.getURLView(liferayPortletResponse, windowState);
    }

    @Override
    public boolean isPrintable() {
        return true;
    }

    private Entry _entry;
}
