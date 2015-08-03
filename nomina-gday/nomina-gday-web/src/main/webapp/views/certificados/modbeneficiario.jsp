<form id="formBeneficiario"  name="formBeneficiario" class="formular" style="width:650px;" action="../../mvc/afiliado/guardar" method="post">
<input type="hidden" id="modhidsumaporc" name="modhidsumaporc"/>
Suma actual de porcenajes asignados:<div id="moddivsumaporcentajes"></div>
	<table border=0>
		<tr>
			<td>		            
			<fieldset> <legend></legend>
			<legend>Nombre</legend>
				<label>	<input value="" class="validate[required] text-input" type="text" name="modnombrebeneficiario" id="modnombrebeneficiario" />
						<input value="" class="validate[required] text-input" type="hidden" name="modidbeneficiario" id="modidbeneficiario" /></label>
			<legend>Apellido Paterno</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="modappbeneficiario" id="modappbeneficiario" /></label>							
			<legend>Apellido Materno</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="modapmbeneficiario" id="modapmbeneficiario" /></label>
			<legend>Revocable</legend>
				<label>
					<select name="modrevocable" id="modrevocable" class="validate[required]">
						<option value="1">SI</option>
						<option value="0">NO</option>
					</select>					
				
				</label>
			<legend>Irrevocable</legend>
				<label>
					<select name="modirrevocable" id="modirrevocable" class="validate[required]">
						<option value="1">SI</option>
						<option value="0">NO</option>
					</select>					
				</label>			
			</fieldset>

			</td>
			<td>
			<fieldset>						
			<legend></legend>
			<legend>Parentesco</legend>
				<label>	
					<select name="modparentescobeneficiario" id="modparentescobeneficiario" class="validate[required]">
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
			<legend>Porcentaje</legend>
				<label>	
					<input type="text" name="modporcentajebeneficiario" id="modporcentajebeneficiario" />						
			</label>
			<legend>Porcentaje gastos funer.:</legend>
				<label>	
					<input type="text" name="modporcentajebeneficiario2" id="modporcentajebeneficiario2" />						
			</label>				
			<legend>Fecha de Nacimiento</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="modfechanacimientobeneficiario" id="modfechanacimientobeneficiario" /></label>
			<legend>Edad</legend>
				<label><input value="" class="validate[required] text-input" type="text" name="modedadbeneficiario" id="modedadbeneficiario" /></label>			
			</fieldset>
			
			</td>
		</tr>	
		</table>		
</form>		            