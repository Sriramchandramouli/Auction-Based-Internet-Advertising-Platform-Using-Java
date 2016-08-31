/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Consumer;

import java.util.ArrayList;

/**
 *
 * @author Sriram
 */
public class ViewHistoryList {
    
    private ArrayList<ViewHistory> viewHistoryDirectory;

    public ViewHistoryList() {
        
        viewHistoryDirectory = new ArrayList<>();
    }

    public ArrayList<ViewHistory> getViewHistoryDirectory() {
        return viewHistoryDirectory;
    }

    public void setViewHistoryDirectory(ArrayList<ViewHistory> viewHistoryDirectory) {
        this.viewHistoryDirectory = viewHistoryDirectory;
    }
    
    public ViewHistory addViewHistory() {
        
        ViewHistory viewHistory = new ViewHistory();
        viewHistoryDirectory.add(viewHistory);
        return viewHistory;
    
}
    
}
