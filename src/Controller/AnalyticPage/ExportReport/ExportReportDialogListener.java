package Controller.AnalyticPage.ExportReport;

import View.AnalyticPage.ExportReport.ExportReportDialog;

import java.awt.event.ActionListener;

public class ExportReportDialogListener implements ActionListener {
    private ExportReportDialog exportReportDialog;
    public ExportReportDialogListener(ExportReportDialog exportReportDialog) {
        this.exportReportDialog = exportReportDialog;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(command);

        if (command.equals("OK")) {
            exportReportDialog.OKButton();
        } else if (command.equals("Cancel")) {
            exportReportDialog.CancelButton();
        }
        else if (command.equals("ADD")) {
            System.out.println("ADD");
            exportReportDialog.AddButton();
        }
        else if (command.equals("REMOVE")) {
            System.out.println("REMOVE");
            exportReportDialog.RemoveButton();
        }
    }
}
