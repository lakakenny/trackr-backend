package de.techdev.trackr.web;

import de.techdev.trackr.domain.support.EmployeeDataOnDemand;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Moritz Schulze
 */
public class EmployeeResourceTest extends MockMvcTest {

    @Autowired
    private EmployeeDataOnDemand employeeDataOnDemand;

    @Before
    public void setUp() throws Exception {
        employeeDataOnDemand.init();
    }

    @Test
    public void root() throws Exception {
        mockMvc.perform(get("/employees")).andExpect(status().isOk()).andExpect(content().contentType(standardContentType));
    }

    @Test
    public void one() throws Exception {
        mockMvc.perform(get("/employees/0")).andExpect(status().isOk()).andExpect(content().contentType(standardContentType));
    }

}
