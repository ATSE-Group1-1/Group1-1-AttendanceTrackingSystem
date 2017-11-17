/**
 * Copyright 2014-2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//[START all]
package de.ase11.attendanceTrackingSystem;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.ObjectifyService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Form Handling Servlet
 * This servlet will take http requests and process them.
 */
public class JoinGroupServlet extends HttpServlet {

    // Process the http POST of the form
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();  // Find out who the user is.

        if(user != null) {
            String joinGroupId = req.getParameter("joinGroupId");
            Long group_id = Long.valueOf(joinGroupId);
            Group group = ObjectifyService.ofy().load().type(Group.class).id(group_id).now();

            boolean join = group.joinGroup(user);

            if(join) {
                ObjectifyService.ofy().save().entity(group).now();
                resp.sendRedirect("/landingpage.jsp");
            } else {
                resp.sendRedirect("/error.jsp?errorCode=2");
            }
        } else {
            resp.sendRedirect("/error.jsp?errorCode=1");
        }
    }
}
//[END all]