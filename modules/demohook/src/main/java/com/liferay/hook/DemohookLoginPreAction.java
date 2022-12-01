package com.liferay.hook;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemohookLoginPreAction extends Action  {
    @Override
    public void run(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ActionException {

        System.out.println("before login ");

    }

    @Override
    public String toString() {
        return "login.portal.jsp";
    }
}
