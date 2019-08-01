package fr.formation.dictionary.controllers;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dictionary.business.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

//	@GetMapping("/hello")
//	public String hello() {
//		return "Hello world!";
//	}
//
//	@GetMapping("/greetings")
//	public ArrayList<String> greetings() {
//		ArrayList<String> greetings = new ArrayList<>();
//		greetings.add("Bonjour");
//		greetings.add("Hello");
//		return greetings;
//
//	}
    @GetMapping("/{id}")
    public Invoice invoice(@PathVariable("id") Long id) { // null (jamais était
							  // sauvegarder)
	LocalDate date = LocalDate.of(2019, 07, 12);
	Invoice invoice = new Invoice("A01", date, 1005.36);
	invoice.setPaid(true);
	invoice.setId(id);
	return invoice;
    }

    @GetMapping()
    public ArrayList<Invoice> invoices() {
	ArrayList<Invoice> invoices = new ArrayList<>();
	LocalDate date = LocalDate.of(2019, 07, 12);
	invoices.add(new Invoice("A01", date, 1005.36));
	invoices.add(new Invoice("A021", date, 1006.36));
	return invoices;
    }

    @GetMapping("/invoices")
    public ArrayList<Invoice> invoices(@RequestParam("size") int size,
	    @RequestParam("page") int page) {
	System.out.println("size=" + size + ", page=" + page);
	LocalDate date = LocalDate.of(1111, 11, 1);
	ArrayList<Invoice> invoices = new ArrayList<>();
	Invoice first = new Invoice("A01", date, 1005.36);
	invoices.add(first);
	Invoice second = new Invoice("A021", date, 1006.36);
	invoices.add(second);
	return invoices;
    }

    @PostMapping()
    public void create(@RequestBody @Valid Invoice invoice) {
	System.out.println(invoice);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
	System.out.println("Deleted invoice with id ");
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id,
	    @RequestBody Invoice invoice) {
	System.out.println(invoice);
    }

    @PatchMapping("/{id}/unpaid")
    public void paid(@PathVariable("id") Long id) {
	System.out.println("Unpatched invoice with id " + id);
    }
}
