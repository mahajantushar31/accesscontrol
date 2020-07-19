package com.demo.accesscontrol.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.accesscontrol.commons.util.CommonUtil;
import com.demo.accesscontrol.dto.RoleMasterDto;
import com.demo.accesscontrol.entity.RoleMaster;
import com.demo.accesscontrol.repository.RoleMasterRepository;
/**
 * @author Tushar mahajan
 *
 */

@RestController
@RequestMapping("/access")
public class AccessController {
	
	@Autowired
	RoleMasterRepository RoleMasterRepository;
	//CommonRepository<RoleMaster> commonRepository;
	
	// get All ROLE
	@GetMapping("/getRoles")
	public ResponseEntity<List<RoleMaster>> getAllNotes(Pageable pageable) {
		List<RoleMaster> roleList = null;
		try {
			roleList = RoleMasterRepository.getAllRole();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return new ResponseEntity(roleList,HttpStatus.OK)   ;
	}
	
	// create a new ROLE/ Register
	@PostMapping("/createRole") //@Valid @RequestBody
	public RoleMaster createNote(@Valid @RequestBody RoleMasterDto roleDto) {
		RoleMaster r=(RoleMaster) CommonUtil.objectUtilMapper(roleDto, new RoleMaster());
				
		System.out.println("role is " +r.toString());
	    return RoleMasterRepository.save(r);
	}
	
	/*
	
	//update /edit
	
	// get single role 
	@GetMapping("/getRole/{id}")
	public RoleMaster getNoteById(@PathVariable(value = "id") Long noteId) {
	    return RoleMasterRepository.findById(noteId)
	            .orElseThrow(() -> new ResourceNotFoundException("Role", "id", noteId));
	}
	
	// Update a Note
	@PutMapping("/notes/{id}")
	public RoleMaster updateNote(@PathVariable(value = "id") Long roleId,
	                                        @Valid @RequestBody RoleMaster noteDetails) {

	    RoleMaster note = RoleMasterRepository.findById(roleId)
	            .orElseThrow(() -> new ResourceNotFoundException("RoleMaster", "id", roleId));

	    // note.setTitle(noteDetails.getRole_id());
	    note.setRoleName(noteDetails.getRoleName());

	    RoleMaster updatedNote = RoleMasterRepository.save(note);
	    return updatedNote;
	}
	
	
	// delete
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long roleId) {
	    RoleMaster note = RoleMasterRepository.findById(roleId)
	            .orElseThrow(() -> new ResourceNotFoundException("Common", "id", roleId));

	    RoleMasterRepository.delete(note);

	    return ResponseEntity.ok().build();
	}
	
	*/
}
