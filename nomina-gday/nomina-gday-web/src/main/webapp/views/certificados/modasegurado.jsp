<form id="formAsegurado"  name="formAsegurado" class="formular" style="width:650px;" action="../../mvc/afiliado/guardar" method="post">
	<table border=0>
		<tr>
			<td>		            
			<fieldset> <legend></legend>
			<legend>Nombre</legend>
				<label>	
					<input value="" class="validate[required] text-input" type="text" name="modnombreasegurado" id="modnombreasegurado" />
					<input value="" class="validate[required] text-input" type="hidden" name="modidasegurado" id="modidasegurado" />
				</label>
			<legend>Apellido Paterno</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="modappasegurado" id="modappasegurado" /></label>							
			<legend>Apellido Materno</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="modapmasegurado" id="modapmasegurado" /></label>			
			</fieldset>
			</td>
			<td>
			<fieldset>						
			<legend></legend>
			<legend>Parentesco</legend>
				<label>	
					<select name="modparentescoasegurado" id="modparentescoasegurado" class="validate[required]">
						<option value="">Seleccione...</option>
						<option value="PADRE">PADRE</option>
						<option value="MADRE">MADRE</option>
						<option value="HERMANO(A)">HERMANO(A)</option>
						<option value="ABUELO(A)">ABUELO(A)</option>						
						<option value="ESPOSO(A)">ESPOSO(A)</option>
						<option value="HIJO(A)">HIJO(A)</option>
						<option value="NIETO(A)">NIETO(A)</option>
						<option value="TIO(A)">TIO(A)</option>
						<option value="SOBRINO(A)">SOBRINO(A)</option>
						<option value="CONCUBINO(A)">CONCUBINO(A)</option>						
						<option value="OTRO">OTRO</option>		
					</select>
				</label>				
			<legend>Fecha de Nacimiento</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="modfechanacimientoasegurado" id="modfechanacimientoasegurado" /></label>
			<legend>Edad</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="modedadasegurado" id="modedadasegurado" /></label>
			</fieldset>
			
			</td>
		</tr>	
		</table>		
</form>		            
