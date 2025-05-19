package com.cat.msa.invoices.service.impl;

import com.cat.msa.invoices.domain.InvoiceHeader;
import com.cat.msa.invoices.repository.InvoiceHeaderRepository;
import com.cat.msa.invoices.service.InvoiceHeaderService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvoiceHeaderServiceImpl implements InvoiceHeaderService {
    private final InvoiceHeaderRepository invoiceHeaderRepository;

    public InvoiceHeaderServiceImpl(InvoiceHeaderRepository invoiceHeaderRepository) {
        this.invoiceHeaderRepository = invoiceHeaderRepository;
    }

    @Override
    public InvoiceHeader createInvoiceHeader(InvoiceHeader invoiceHeader) {
        invoiceHeader.calculateInvoiceAmount();
        return invoiceHeaderRepository.save(invoiceHeader);
    }

    @Override
    public List<InvoiceHeader> getAll() {
        List<InvoiceHeader> invoiceHeaders = invoiceHeaderRepository.findAll();
        if (invoiceHeaders.isEmpty()) {
            throw new RuntimeException("No invoices found");
        }
        return invoiceHeaders;
    }

    @Override
    public InvoiceHeader findByNumber(String number) {
        return invoiceHeaderRepository.findByNumber(number)
                .orElseThrow(() -> new RuntimeException("Invoice not found with number"));
    }
    @Override
    public void deleteByNumber(String number) {
        InvoiceHeader invoice = invoiceHeaderRepository.findByNumber(number)
                .orElseThrow(() -> new RuntimeException("Invoice not found with number: " + number));
        invoiceHeaderRepository.delete(invoice);
    }
}